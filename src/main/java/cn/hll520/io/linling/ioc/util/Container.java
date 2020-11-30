package cn.hll520.io.linling.ioc.util;

import java.util.Map;

/**
 * @author lpc
 * @version 1.0  2020-11-27-17:09
 * @since 2020-11-27-17:09
 * 描述：类对象资源容器
 */
public interface Container<T> {
    /**
     * 获取当前的实例对象组
     *
     * @return 实例对象组
     */
    Map<String, T> getContainer();

    /**
     * 更新待注入对象中的对象
     *
     * @param className 全类名
     * @param instance  对象
     */
    void updateInstance(String className, T instance);

    /**
     * 向容器内添加一个实例
     *
     * @param className 全类名
     * @param instance  实例
     */
    void insertInstance(String className, T instance);


    /**
     * 删除一个实例
     *
     * @param className 全类名
     */
    void deleteInstance(String className);

    /**
     * 根据全类名获取对象
     *
     * @param className 全类名
     * @return 实例化的对象
     */
    T getInstance(String className);
}
