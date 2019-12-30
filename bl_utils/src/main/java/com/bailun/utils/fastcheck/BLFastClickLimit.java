package com.bailun.utils.fastcheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create by chl on 2019/12/24
 * description : 限制快速点击
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BLFastClickLimit {

    /**
     * 默认设置500毫秒的间隔
     * @return
     */
    long spaceTime() default 500;
}
