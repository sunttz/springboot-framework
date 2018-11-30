package com.stt.springbootframework.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * service的方法执行时间统计
 */
@Aspect
@Component
public class LogServiceTakeTime {

    final static Logger log = LoggerFactory.getLogger(LogServiceTakeTime.class);

    @Pointcut("execution(* com.stt.springbootframework.service..*.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();//获取方法名
        String className = joinPoint.getTarget().getClass().getName();//获取所在实体类
        log.info("调用方法：{}", className + "." + methodName);
        //记录起始时间
        long begin = System.currentTimeMillis();
        Object result = "";
        /** 执行目标方法 */
        result = joinPoint.proceed();
        /** 记录操作时间 */
        long took = (System.currentTimeMillis() - begin) / 1000;
        if (took >= 10) {
            log.error("Service 执行时间为: {}秒", took);
        } else if (took >= 5) {
            log.warn("Service 执行时间为: {}秒", took);
        } else {
            log.info("Service执行时间为: {}秒", took);
        }
        return result;
    }

    @Before("performance()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        log.info("doBefore");
    }

    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("doAfterReturning");
    }

}