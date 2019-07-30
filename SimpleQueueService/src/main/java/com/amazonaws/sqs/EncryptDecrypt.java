package com.amazonaws.sqs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class EncryptDecrypt {

    public void runEncryptionTest() throws Exception {
		 
	    /*
        * The ProfileCredentialsProvider will return your [default]
        * credential profile by reading from the credentials file located at
        * (C:\\Users\\jmzombe\\.aws\\credentials).
        */
        ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\jmzombe\\.aws\\credentials), and is in valid format.",
                    e);
        }
        
        System.out.println("=================================================");
        System.out.println("Getting Started with Amazon SQS using encryption.");
        System.out.println("===============================================\n");
        
        //final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.US_EAST_1) //     .US_WEST_2)
                .build();
        
        
        
        
        final Map<String, String> attributes = new HashMap<String, String>();
               
        // Enable sse by specifying the alias ARN of the AWS managed CMK for Amazon SQS.
        final String kmsMasterKeyAlias = "arn:aws:kms:us-east-2:018902628565:key/e3beed1a-793d-4b9d-bc82-7c0610aa25aa:alias/aws/et";
        attributes.put("KmsMasterKeyId", kmsMasterKeyAlias);
      
        // Specify the length of time, in seconds, for which Amazon SQS can reuse 
        attributes.put("KmsDataKeyReusePeriodSeconds", "60");
        
        // Create a queue with sse
        System.out.println("Creating a new SQS Encryption queue called JimmyZ-Q.\n");
        CreateQueueRequest createQueueRequest = new CreateQueueRequest("JimmyZ-Q").withAttributes(attributes);
        String myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();
        
        // List queues
        System.out.println("Listing all queues in your account.\n");
        for (String queueUrl : sqs.listQueues().getQueueUrls()) {
            System.out.println("  QueueUrl: " + queueUrl);
        }
        System.out.println();
        
        // Send a message
        System.out.println("Sending a message to JimmyZ-Q.\n");
        sqs.sendMessage(new SendMessageRequest(myQueueUrl, "This is my message text."));
        
        // Receive messages
        System.out.println("Receiving messages from JimmyZ-Q.\n");
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl);
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        for (Message message : messages) {
            System.out.println("  Message");
            System.out.println("    MessageId:     " + message.getMessageId());
            System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
            System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
            System.out.println("    Body:          " + message.getBody());
            for (Entry<String, String> entry : message.getAttributes().entrySet()) {
                System.out.println("  Attribute");
                System.out.println("    Name:  " + entry.getKey());
                System.out.println("    Value: " + entry.getValue());
            }
        }
        System.out.println();
        
        // Delete a message
        System.out.println("Deleting a message.\n");
        String messageReceiptHandle = messages.get(0).getReceiptHandle();
        sqs.deleteMessage(new DeleteMessageRequest(myQueueUrl, messageReceiptHandle));

        // Delete a queue
        System.out.println("Deleting the test queue.\n");
        sqs.deleteQueue(new DeleteQueueRequest(myQueueUrl));
     }
	
}
