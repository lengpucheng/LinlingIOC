package cn.hll520.io.linling.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-27-15:24
 * @since 2020-11-27-15:24
 * 描述： 被代理的对象
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgencyProxy {
    String value(); // 标识代理的方法ID
}
