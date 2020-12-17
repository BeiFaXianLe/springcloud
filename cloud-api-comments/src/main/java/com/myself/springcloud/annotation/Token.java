package com.myself.springcloud.annotation;

import java.lang.annotation.*;

/**
 * @Author zxy
 * @Date: 2020/06/26/ 23:41
 * @Description
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //保留注解的各种策略，它们与元注解(@Retention)一起指定注释要保留多长时间
@Documented
public @interface Token {

    String value() default "";

}
