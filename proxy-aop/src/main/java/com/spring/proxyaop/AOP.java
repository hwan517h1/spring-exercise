package com.spring.proxyaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    // @Around: 어떻게 적용할 수 있는가, target 실행 중 혹은 전후 모두 가능함
//    @Around("execution(* com.navercorp.toktok..*.EventService.*(..))")
//    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = pjp.proceed();
//        System.out.println(System.currentTimeMillis() - start);
//
//        return result;
//    }

    // 특정 메소드에 대한 적용을 원하는 경우 Annotation을 생성함: Logging
    @Around("@annotation(com.spring.proxyaop.Logging)")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        System.out.println(System.currentTimeMillis() - start);

        return result;
    }

    @Before("bean(anEventService)")
    public void ref() {
        System.out.println("@Before");
    }
}