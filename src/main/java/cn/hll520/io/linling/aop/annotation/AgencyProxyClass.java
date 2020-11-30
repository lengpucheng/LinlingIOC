package cn.hll520.io.linling.aop.annotation;

import cn.hll520.io.linling.ioc.annotation.Module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-14:03
 * @since 2020-11-30-14:03
 * 描述：描述代理类
 */
@Module
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgencyProxyClass {
}
