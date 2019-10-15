package com.spring.proxyaop;

import java.lang.annotation.*;

// Annotation 생성

@Documented
@Retention(RetentionPolicy.CLASS) // 해당 annotaion 정보를 얼마나 유지할 것인가
@Target(ElementType.METHOD)
public @interface Logging {}
