package cn.hll520.io.linling.ioc.container;

import cn.hll520.io.linling.ioc.annotation.AutoInject;
import cn.hll520.io.linling.ioc.util.Container;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * @author lpc
 * @version 1.0  2020-11-26-16:00
 * @since 2020-11-26-16:00
 * 描述：对含有指定标签的类进行依赖注入
 */
public class ApplicationDependInject {
    private final Container<Object> applicationContainer;

    public ApplicationDependInject(Container<Object> applicationContainer) {
        this.applicationContainer = applicationContainer;
    }

    /**
     * 运行注入
     */
    protected void run() {
        dependInject();
    }


    /**
     * 依赖注入
     */
    private void dependInject() {
        Set<Map.Entry<String, Object>> entries = applicationContainer.getContainer().entrySet();
        // 遍历对象
        for (Map.Entry<String, Object> entry : entries) {
            // 获取对象的全部字段
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();
            // 遍历字段是否含有 @AutoInject 注解，若有进行注入
            for (Field field : declaredFields) {
                inject(entry.getValue(), field);
            }
        }
    }

    /**
     * 注入
     *
     * @param object 原对象
     * @param field  需要注入的字段
     */
    private void inject(Object object, Field field) {
        if (field.isAnnotationPresent(AutoInject.class)) {
            // 获取其属性的全类名从而获取其对象
            Object element = applicationContainer.getContainer().get(field.getType().getCanonicalName());
            // 设置为可修改
            field.setAccessible(true);
            // 注入
            try {
                field.set(object, element);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
