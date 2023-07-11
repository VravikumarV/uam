package com.techgaints.plugins.uam.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//@Service
public class NotificationService {

    private String S3_BKT_FILEUPLOAD_ARN = "arn:aws:s3:::s3bkt-fileupload";
    private String SNS_FILEUPLOAD_ARN = "arn:aws:sns:ap-south-1:222643010932:sns-fileupload";
    private String SQS_FILEUPLOAD_ARN = "arn:aws:sqs:ap-south-1:222643010932:sqs-fileupload";


    //@Autowired
    private NotificationMessagingTemplate NotificationMessagingTemplate;

    private void subscribeToTopic(String topic, String email) {
        SubscribeRequest subscribeRequest = new SubscribeRequest().withProtocol("email").withEndpoint(email).withReturnSubscriptionArn(true).withTopicArn(SNS_FILEUPLOAD_ARN);

    }

    private void notifyToSubsriber() {

    }

    private void unSubscribeFromTopic(String topic, String email) {
        SubscribeRequest subscribeRequest = new SubscribeRequest().withProtocol("email").withEndpoint(email).withReturnSubscriptionArn(true).withTopicArn(SNS_FILEUPLOAD_ARN);

    }

}
