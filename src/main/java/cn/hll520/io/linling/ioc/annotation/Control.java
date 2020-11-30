package cn.hll520.io.linling.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:51
 * @since 2020-11-26-9:51
 * 描述：服务控制
 */
@Module
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Control {
    /**
     * path 路径
     *
     * @return path
     */
    String value() default "/";

    /**
     * 访问方法
     *
     * @return 访问方法
     */
    Method method() default Method.GET;

    /**
     * 标签
     *
     * @return 标签
     */
    String tag() default "";

    /**
     * 描述
     *
     * @return 描述
     */
    String describe() default "";

}

