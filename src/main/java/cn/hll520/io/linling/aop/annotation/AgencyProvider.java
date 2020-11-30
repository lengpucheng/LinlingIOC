package cn.hll520.io.linling.aop.annotation;

import cn.hll520.io.linling.ioc.annotation.Module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-27-15:39
 * @since 2020-11-27-15:39
 * 描述： 标记代理提供者，只能在类上
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Module  // 标记为组件
public @interface AgencyProvider {
    String value(); // 要和被代理的ID一样

    double version() default 1.0; // 如果相同

    boolean enable() default true;
}
