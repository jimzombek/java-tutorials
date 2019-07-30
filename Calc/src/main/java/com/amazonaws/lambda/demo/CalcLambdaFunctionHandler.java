package com.amazonaws.lambda.demo;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CalcLambdaFunctionHandler implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> input,  Context context) {
        
      	LambdaLogger logger = context.getLogger();
      	logger.log("Loading the calculator Lambda function");
      	
       	logger.log("Input: " + input);
       	logger.log("path parm1: " + input.get("a"));
       	logger.log("path parm2: " + input.get("b"));
       	logger.log("path parm3: " + input.get("op"));
       	
      	logger.log("Lambda time in ms: " + String.valueOf(context.getRemainingTimeInMillis())); // Returns the number of milliseconds left before the execution times out.
    	logger.log("Lambda function name: " + context.getFunctionName());                       // Returns the name of the Lambda function.
    	logger.log("Lambda function version: " + context.getFunctionVersion());                 // Returns the version of the function.
    	logger.log("Lambda function ARN: " + context.getInvokedFunctionArn());                  // Returns the Amazon Resource Name (ARN) used to invoke the function. Indicates if the invoker specified a version number or alias.
    	logger.log("Lambda memory limit: " + String.valueOf(context.getMemoryLimitInMB()));     // Returns the amount of memory configured on the function.
    	logger.log("Lambda request ID: " + context.getAwsRequestId());                          // Returns the identifier of the invocation request.
       	logger.log("Lambda log group name: " + context.getLogGroupName());                      // Returns the log group for the function.
    	logger.log("Lambda log stream name: " + context.getLogStreamName());                    // Returns the log stream for the function instance.

    	//logger.log(context.getIdentity()); // (mobile apps) Returns information about the Amazon Cognito identity that authorized the request.
    	//logger.log(context.getClientContext()); // (mobile apps) Returns the client context provided to the Lambda invoker by the client application.
    	
    	 //MyLambdaResponse lambdaResponse = new MyLambdaResponse();
         //try {
         //    lambdaResponse.setResponseMessage("Hello " + input + " Response Time : " + new Date());
         //    lambdaResponse.setTransactionID(UUID.randomUUID().toString());
         //} catch (Exception e) {
         //    e.printStackTrace();
         //    lambdaResponse.setResponseMessage(e.getMessage());
         //}
         //context.getLogger().log("Response : " + lambdaResponse);
         
         return "jimmyz";
    }

        	   	
    	
    	/*
        exports.handler = function(event, context, callback) {
            console.log('Received event:', JSON.stringify(event, null, 2));
            if (event.a === undefined || event.b === undefined || event.op === undefined) {
                callback("400 Invalid Input");
            }
            
            var res = {};
            res.a = Number(event.a);
            res.b = Number(event.b);
            res.op = event.op;
            
            if (isNaN(event.a) || isNaN(event.b)) {
                callback("400 Invalid Operand");
            }

            switch(event.op)
            {
                case "+":
                case "add":
                    res.c = res.a + res.b;
                    break;
                case "-":
                case "sub":
                    res.c = res.a - res.b;
                    break;
                case "*":
                case "mul":
                    res.c = res.a * res.b;
                    break;
                case "/":
                case "div":
                    res.c = res.b===0 ? NaN : Number(event.a) / Number(event.b);
                    break;
                default:
                    callback("400 Invalid Operator");
                    break;
            }
            callback(null, res);
        };
    }
    */

}
