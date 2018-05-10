package com.ejoylot.controller;

import com.ejoylot.message.ResultEntity;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class ControllerAspect {
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Around("execution(* com.ejoylot.controller..*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        ResultEntity<?> resultEntity;
        try {
            logger.info("执行Controller开始: " + pjp.getSignature() + " 参数：" + Lists.newArrayList(pjp.getArgs()).toString());
            resultEntity = (ResultEntity<?>) pjp.proceed(pjp.getArgs());
            logger.info("执行Controller结束: " + pjp.getSignature() + "， 返回值：" + resultEntity.toString());
            logger.info("耗时：" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) + "(毫秒).");
        } catch (Throwable throwable) {
            resultEntity = handlerException(pjp, throwable);
        }

        return resultEntity;
    }

    private ResultEntity<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultEntity<?> resultEntity = null;
        if (e instanceof RuntimeException) {
            logger.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            resultEntity = ResultEntity.fail(e.getMessage());
        } else {
            logger.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            resultEntity = ResultEntity.fail(e.getMessage());
        }

        return resultEntity;
    }
}
