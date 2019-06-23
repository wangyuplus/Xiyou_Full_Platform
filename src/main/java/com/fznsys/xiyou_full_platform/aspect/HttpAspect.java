
package com.fznsys.xiyou_full_platform.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class HttpAspect {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.fznsys.xiyou_full_platform.controller.order.MenuController.getlist(..))")
    public void HttpAspect() {

    }

    @Before("HttpAspect()")
    public void HttpaAspect1() {
        logger.info("Before");
        System.out.println("login()开始");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


    }

    @After("HttpAspect()")
    public void HttpaAspect2() {
        logger.info("after");
        System.out.println("login()结束");
    }

    @AfterReturning(returning = "object", pointcut = "HttpAspect()")
    public void HttpAspect3(Object object) {
        logger.info("reponse={}", object);
    }

}
