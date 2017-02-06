package jp.gr.java_conf.kojiisd.controller;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author kojiisd
 */
@RestController
public class LambdaRestController {

    @Value("${lambda-rest.target}")
    private String targetClassPath;

    @RequestMapping(value = {"lambdalocal", "lambdalocal/"}, method = RequestMethod.POST)
    public String index(@RequestBody String input) throws Exception {
        Class targetClass = Class.forName(this.targetClassPath);
        Object targetObject = targetClass.newInstance();
        Context context = createDefaultContext();

        Method targetMethod = targetObject.getClass().getMethod("handleRequest", String.class, Context.class);
        targetMethod.invoke(targetObject, input, context);

        return "Success";
    }

    @RequestMapping(value = {"console", "console/"}, method = RequestMethod.POST)
    public String consoleLocal(@RequestBody String input) throws Exception {
        System.out.println(input);

        return "Success";
    }


    private Context createDefaultContext() {
        return new Context() {
            @Override
            public String getAwsRequestId() {
                return null;
            }

            @Override
            public String getLogGroupName() {
                return null;
            }

            @Override
            public String getLogStreamName() {
                return null;
            }

            @Override
            public String getFunctionName() {
                return null;
            }

            @Override
            public String getFunctionVersion() {
                return null;
            }

            @Override
            public String getInvokedFunctionArn() {
                return null;
            }

            @Override
            public CognitoIdentity getIdentity() {
                return null;
            }

            @Override
            public ClientContext getClientContext() {
                return null;
            }

            @Override
            public int getRemainingTimeInMillis() {
                return 0;
            }

            @Override
            public int getMemoryLimitInMB() {
                return 0;
            }

            @Override
            public LambdaLogger getLogger() {
                return null;
            }
        };
    }
}
