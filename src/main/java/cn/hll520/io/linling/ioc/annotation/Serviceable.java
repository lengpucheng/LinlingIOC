package cn.hll520.io.linling.ioc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:53
 * @since 2020-11-26-9:53
 * 描述： 标记服务实现类
 */
@Module
@Retention(RetentionPolicy.RUNTIME)
public @interface Serviceable {
    Class<?>[] value() default {}; // 目标接口

    int priority() default 1;  // 优先级

    double version() default 1.0; // 版本
}
