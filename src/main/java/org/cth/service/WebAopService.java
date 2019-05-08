package org.cth.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Aspect
@Service
public class WebAopService {
    private Logger log = LoggerFactory.getLogger(WebAopService.class);

    @Pointcut("execution(public * org.cth.controller..*.*(..))")
    public void webLog(){}

    @Pointcut("execution(* org.cth.controller.TestController.testGet1(..))")
    public void webLog1(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        log.info(">>>" + joinPoint.getSignature() + ">>>" + joinPoint.getTarget().getClass().getName());  //返回方法签名和目标对象的类名
    }

    @AfterReturning(pointcut = "webLog1()", returning = "resp")
    public void doAfter(Object resp){
        log.info(">>>" + resp.getClass().getName());
        if (resp instanceof HashMap) {
            log.info(">>>" + ((HashMap) resp).get("code"));
        }
    }
}
