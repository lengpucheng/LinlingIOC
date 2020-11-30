package cn.hll520.io.linling.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:49
 * @since 2020-11-26-9:49
 * 描述： 标记普通组件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Module {
    /**
     * 用来默认参数
     * @return 类型
     */
    String value() default "";
}
