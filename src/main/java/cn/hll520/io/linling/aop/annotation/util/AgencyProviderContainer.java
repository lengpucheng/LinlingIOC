package cn.hll520.io.linling.aop.annotation.util;

import cn.hll520.io.linling.ioc.util.Container;
import cn.hll520.io.linling.aop.annotation.AgencyProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-10:23
 * @since 2020-11-30-10:23
 * 描述：代理实现类容器
 */
public class AgencyProviderContainer implements Container<AgencyProviderInstance> {

    private final Map<String, AgencyProviderInstance> agency_id_container = new HashMap<>();

    /**
     * 从已存在的容器中构建
     *
     * @param container 组件容器
     */
    public AgencyProviderContainer(Container<Object> container) {
        Set<Map.Entry<String, Object>> entries = container.getContainer().entrySet();
        for (Map.Entry<String, Object> element : entries) {
            // 获取提供者注解
            AgencyProvider annotation = element.getValue().getClass().getAnnotation(AgencyProvider.class);
            // 判断是否存在
            if (null != annotation) {
                // 构建一个AgencyProviderInstance 对象
                AgencyProviderInstance providerDescribe = new AgencyProviderInstance(annotation, element.getValue());
                // 添加全类名
                providerDescribe.setClassName(element.getKey());
                // 添加到 容器中
                agency_id_container.put(providerDescribe.getId(), providerDescribe);
            }
        }
    }

    @Override
    public Map<String, AgencyProviderInstance> getContainer() {
        return agency_id_container;
    }

    @Override
    public void updateInstance(String id, AgencyProviderInstance instance) {
        agency_id_container.put(id, instance);
    }

    @Override
    public void insertInstance(String id, AgencyProviderInstance instance) {
        agency_id_container.put(id, instance);
    }

    @Override
    public void deleteInstance(String id) {
        agency_id_container.remove(id);
    }

    @Override
    public AgencyProviderInstance getInstance(String id) {
        return agency_id_container.get(id);
    }
}
