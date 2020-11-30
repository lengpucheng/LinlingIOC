package cn.hll520.io.linling.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:50
 * @since 2020-11-26-9:50
 * 描述：自动注入
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInject {
}
