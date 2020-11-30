package cn.hll520.io.linling.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-27-15:49
 * @since 2020-11-27-15:49
 * 描述：设置代理提供内的方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgencyProviderMethod {
    AgencyPoint value() default AgencyPoint.BEFORE_AND_AFTER; // 被代理的位置
}
