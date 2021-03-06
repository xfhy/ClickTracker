package com.xfhy.library;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : xfhy
 * Create time : 2020/8/23 10:54 PM
 * Description : 不需要防抖,则加入这个注解
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface NoFastClickTrack {
}