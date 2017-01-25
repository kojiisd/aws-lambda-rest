package jp.gr.java_conf.kojiisd.controller;

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

    @RequestMapping(value = {"/", ""}, method= RequestMethod.POST)
    public String index(@RequestBody String input) throws Exception{
        Class targetClass = Class.forName(this.targetClassPath);
        Method targetMethod = targetClass.getClass().getMethod("handlerRequest", new Class[]{targetClass.getClass()});
        targetMethod.invoke(targetClass, new Object[]{input});

        return "Success";
    }
}
