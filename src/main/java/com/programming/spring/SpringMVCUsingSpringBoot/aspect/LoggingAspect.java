package com.programming.spring.SpringMVCUsingSpringBoot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){}

    //Advice
    @Before("executeLogging()")
    public void logDifferentMethodCalls(JoinPoint jointPoint){
        StringBuilder message = new StringBuilder("Method :");
        message.append(jointPoint.getSignature().getName());
        Object[] args = jointPoint.getArgs();
        if(null!= args && args.length>0){
            message.append(" args = [ | ");
            Arrays.asList(args).forEach(arg -> {
                message.append(arg).append(" | ");
            });
            message.append("]");
        }
        logger.info(message.toString());
    }
}
