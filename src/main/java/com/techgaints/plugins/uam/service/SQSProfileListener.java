package com.techgaints.plugins.uam.service;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

//@Service
public class SQSProfileListener {


    //@SqsListener("sqs-fileupload")
    public void receiveFileUploadMessage(String message) {
        System.out.println("Received Message:  "+message);
    }

    //@SqsListener("sqs-profile-uploaded")
    public void receiveProfileMessage(String message) {
        System.out.println("Received Message:  "+message);
    }


}
