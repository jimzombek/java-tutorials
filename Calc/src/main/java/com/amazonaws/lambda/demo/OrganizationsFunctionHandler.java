package com.amazonaws.lambda.demo;

//import java.util.Map;

import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

//public class OrganizationsFunctionHandler implements RequestHandler<Map<String, Object>, String> {
public class OrganizationsFunctionHandler implements RequestHandler<Request<?>, String> {

    @Override
    //public String handleRequest(Map<String, Object> input,  Context context) {
    public String handleRequest(Request<?> request,  Context context) {
        
      	LambdaLogger logger = context.getLogger();
      	logger.log("Loading the Organization Lambda function");
      	
      	request.getParameters();
      	request.getEndpoint();
      	request.getHttpMethod();
      	request.getResourcePath();
      	request.getContent();
      	
      	 switch (request.getHttpMethod()) {
           case HEAD:
        	 logger.log("HTTP HEAD");
           case GET:
        	 logger.log("HTTP GET");
           case DELETE:
        	 logger.log("HTTP DELETE");
           case OPTIONS:
        	 logger.log("HTTP OPTIONS");
           case PATCH:
        	 logger.log("HTTP PATCH");
           case POST:
        	 logger.log("HTTP POST");
           case PUT:
        	 logger.log("HTTP PUT");
           default:
        	 logger.log("UNKNOWN HTTP REQUEST: " + request.getHttpMethod());
        }
      	
       	//logger.log("Input: " + input);
       	//logger.log("path parm1: " + input.get("a"));
       	//logger.log("path parm2: " + input.get("b"));
       	//logger.log("path parm3: " + input.get("op"));
       	
      	logger.log("Lambda time in ms: " + String.valueOf(context.getRemainingTimeInMillis())); // Returns the number of milliseconds left before the execution times out.
    	logger.log("Lambda function name: " + context.getFunctionName());                       // Returns the name of the Lambda function.
    	logger.log("Lambda function version: " + context.getFunctionVersion());                 // Returns the version of the function.
    	logger.log("Lambda function ARN: " + context.getInvokedFunctionArn());                  // Returns the Amazon Resource Name (ARN) used to invoke the function. Indicates if the invoker specified a version number or alias.
    	logger.log("Lambda memory limit: " + String.valueOf(context.getMemoryLimitInMB()));     // Returns the amount of memory configured on the function.
    	logger.log("Lambda request ID: " + context.getAwsRequestId());                          // Returns the identifier of the invocation request.
       	logger.log("Lambda log group name: " + context.getLogGroupName());                      // Returns the log group for the function.
    	logger.log("Lambda log stream name: " + context.getLogStreamName());                    // Returns the log stream for the function instance.
    	        
        return "organization";
    }

}
