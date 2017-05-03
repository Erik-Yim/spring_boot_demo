package org.erik.spring.boot.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Erik_Yim on 2017/5/3.
 */
@Aspect
@Component
public class AspectDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectDemo.class);


    @Pointcut("execution(public * org.erik.spring.boot.demo.controller.*.*(..))")
    public void log() {

    }


    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("url={}", request.getRequestURL());
        LOGGER.info("method={}", request.getMethod());
        LOGGER.info("ip={}", request.getRemoteAddr());
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("args={}", joinPoint.getArgs());
    }


}
