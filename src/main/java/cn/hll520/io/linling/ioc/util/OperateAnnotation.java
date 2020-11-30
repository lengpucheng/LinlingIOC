package cn.hll520.io.linling.ioc.util;

import javax.annotation.*;
import java.lang.annotation.*;

/**
 * @author lpc
 * @version 1.0  2020-11-26-15:01
 * @since 2020-11-26-15:01
 * 描述：选择注解相关
 */
public class OperateAnnotation {

    /**
     * 检验一个类是否含有某个注解，或继承于某个注解
     *
     * @param clazz      类
     * @param annotation 注解
     * @return 是 true 否 false
     */
    public static boolean whetherIncludeAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        boolean flag = false;
        if(annotation==null)
            return false;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation element : annotations) {
            Class<? extends Annotation> annotationType = element.annotationType();
            if (!whetherDeriveAnnotation(annotationType)) {
                if (annotationType == annotation)
                    flag = true;
                else
                    flag = flag || whetherIncludeAnnotation(annotationType, annotation); // 若有一个符合即可
            }
        }
        return flag;
    }

    /**
     * 判断这个注解是不是JAVA原生注解，因为原生注解会递归调用
     *
     * @param annotation 注解
     * @return 是返回true 否返回false
     */
    public static boolean whetherDeriveAnnotation(Class<? extends Annotation> annotation) {
        return annotation == Deprecated.class ||
                annotation == SuppressWarnings.class ||
                annotation == Override.class ||
                annotation == PostConstruct.class ||
                annotation == PreDestroy.class ||
                annotation == Resource.class ||
                annotation == Resources.class ||
                annotation == Generated.class ||
                annotation == Target.class ||
                annotation == Retention.class ||
                annotation == Documented.class ||
                annotation == Inherited.class;
    }
}
