package com.example.patternrecognition.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Aspect
@Slf4j
public class Logger {

    private static final Set<String> IGNORED_METHODS = Set.of("getErrors");

    @Around("execution(public * com.example.patternrecognition.controller.*Controller.*(..))")
    public Object logController(final ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object obj = null;
        if (!IGNORED_METHODS.contains(methodName)) {
            log.debug("Starting {}", methodName);
            long start = System.currentTimeMillis();
            Exception exception = null;
            try {
                obj = joinPoint.proceed();
            } catch (Exception e) {
                exception = e;
                throw e;
            } finally {
                int diffSeconds = (int) ((System.currentTimeMillis() - start) / 1000);
                log.debug("Finishing {}. Took {} seconds.", methodName, diffSeconds);
                if (exception != null) {
                    log.error("Exception was found during " + methodName, exception);
                }
            }
        }
        return obj;
    }
}
