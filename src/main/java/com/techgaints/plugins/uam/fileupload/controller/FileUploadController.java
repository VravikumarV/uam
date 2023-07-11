package com.techgaints.plugins.uam.fileupload.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Slf4j
/*@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")*/
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    //@Autowired
    private AmazonS3Client awsS3Client;

    //@Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    //@Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

    private String S3_BKT_FILEUPLOAD = "s3bkt-fileupload";  //arn:aws:s3:::s3bkt-fileupload
    private String SNS_FILEUPLOAD = "sns-fileupload";       //arn:aws:sns:ap-south-1:222643010932:sns-fileupload
    private String SQS_FILEUPLOAD = "sqs-fileupload";       //arn:aws:sqs:ap-south-1:222643010932:sqs-fileupload

    private String S3_BKT_FILEUPLOAD_ARN = "arn:aws:s3:::s3bkt-fileupload";
    private String SNS_FILEUPLOAD_ARN = "arn:aws:sns:ap-south-1:222643010932:sns-fileupload";
    private String SQS_FILEUPLOAD_ARN = "arn:aws:sqs:ap-south-1:222643010932:sqs-fileupload";

    //@PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("File") MultipartFile multipartFile) {
        log.info(multipartFile.getName(), multipartFile.getContentType(), multipartFile.getOriginalFilename(), multipartFile.getSize());
        String filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        String key = java.util.UUID.randomUUID().toString() + "." +filenameExtension;

        String fileURL;

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(multipartFile.getSize());
        metaData.setContentType(multipartFile.getContentType());

        try {
            PutObjectResult putObjectResult = awsS3Client.putObject(S3_BKT_FILEUPLOAD, key, multipartFile.getInputStream(), metaData);
            fileURL = awsS3Client.getResourceUrl(S3_BKT_FILEUPLOAD, key);

            queueMessagingTemplate.convertAndSend(SQS_FILEUPLOAD, "File uploaded to S3 bucket and URL for this file is "+fileURL);

            Message<String> payload = MessageBuilder
                    .withPayload("An email notification for New upload happened: " + fileURL + "/" + key)
                    .build();

            notificationMessagingTemplate.convertAndSend("sns-fileupload", payload);

        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occured while uploading the file");
        }

        //awsS3Client.setObjectAcl(S3_BKT_FILEUPLOAD, key, CannedAccessControlList.PublicRead);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }



}
