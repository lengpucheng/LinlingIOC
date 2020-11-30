package cn.hll520.io.linling.ioc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:51
 * @since 2020-11-26-9:51
 * 描述：标记接口服务
 */
@Module
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    Class<?> value() default Service.class; // 指定实现类
}
