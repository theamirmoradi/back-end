package com.twitter.demo.modules.activity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class ActivityLoggingAspect {

    @Autowired
    private ActivityRepository repository;

    @Before("@annotation(com.nila.masterclass.modules.activity.ActLog)")
    public void logging(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ActLog annotation = method.getAnnotation(ActLog.class);
        String entity = annotation.entity();
        ActivityType type = annotation.type();
        var employee = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        Activity activity = Activity.builder().entity(entity).type(type).userId(employee).
                username(employee).description(Arrays.toString(joinPoint.getArgs())).build();
        repository.save(activity);
    }
}
