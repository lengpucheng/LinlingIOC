package cn.hll520.io.linling.ioc.container;

import cn.hll520.io.linling.ioc.util.Container;
import cn.hll520.io.linling.ioc.annotation.Module;
import cn.hll520.io.linling.ioc.util.LoadClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lpc
 * @version 1.0  2020-11-26-15:22
 * @since 2020-11-26-15:22
 * 描述：对象容器，存储实例化对象
 */
public class ApplicationContainer implements Container<Object> {
    private final LoadClass loadClass; // 类加载器
    private final Map<String, Object> beanPool = new HashMap<>(); // 待注入对象集合


    /**
     * 构造函数
     *
     * @param loadClass 类加载器
     */
    protected ApplicationContainer(LoadClass loadClass) {
        this.loadClass = loadClass;
    }

    /**
     * 运行实例化
     */
    protected void run() {
        newInstance();
    }

    /**
     * 向容器内添加一个实例
     *
     * @param className 全类名
     * @param instance  实例
     */
    public void insertInstance(String className, Object instance) {
        beanPool.put(className, instance);
    }

    /**
     * 删除一个实例
     *
     * @param className 全类名
     */
    public void deleteInstance(String className) {
        beanPool.remove(className);
    }

    /**
     * 更新待注入对象中的对象
     *
     * @param className 全类名
     * @param instance  对象
     */
    public void updateInstance(String className, Object instance) {
        beanPool.put(className, instance);
    }

    /**
     * 根据全类名获取对象
     *
     * @param className 全类名
     * @return 实例化的对象
     */
    public Object getInstance(String className) {
        return beanPool.get(className);
    }

    /**
     * 获取当前的实例对象组
     *
     * @return 实例对象组
     */
    public Map<String, Object> getContainer() {
        return beanPool;
    }

    /**
     * 遍历类并对其进行实例化
     */
    private void newInstance() {
        // 加载全部含有 Module 注解的类
        Map<String, Class<?>> classMap = loadClass.loadClass(ApplicationResource.APP_FILE, Module.class);
        // 遍历类并对其进行进行实例化
        Set<Map.Entry<String, Class<?>>> entries = classMap.entrySet();
        for (Map.Entry<String, Class<?>> element : entries) {
            try {
                System.out.println(element.getKey() + "\n" + element.getValue() + "\n___");
                if (!element.getValue().isInterface())
                    beanPool.put(element.getKey(), element.getValue().newInstance());
                else {// 如果是接口
                    System.out.println(element.getValue() + " is interface");
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.out.println("非法侵入！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


}
