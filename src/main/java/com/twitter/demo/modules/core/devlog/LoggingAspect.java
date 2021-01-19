package com.twitter.demo.modules.core.devlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("@annotation(com.nila.masterclass.modules.core.devlog.DevLog)")
    public void logging(JoinPoint joinPoint) {
        StringBuilder massage = new StringBuilder();
        massage.append("Running METHOD: ").append(joinPoint.toString());
        if (joinPoint.getArgs().length > 0)
            massage.append("Passed args: ").append(Arrays.toString(joinPoint.getArgs()));
    }
}
