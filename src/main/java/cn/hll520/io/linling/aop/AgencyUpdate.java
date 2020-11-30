package cn.hll520.io.linling.aop;

import cn.hll520.io.linling.aop.agency.AgencyProxyBuild;
import cn.hll520.io.linling.aop.annotation.AgencyProxy;
import cn.hll520.io.linling.aop.annotation.AgencyProxyClass;
import cn.hll520.io.linling.aop.annotation.util.AgencyProviderContainer;
import cn.hll520.io.linling.ioc.util.Container;

import java.util.Map;
import java.util.Set;

/**
 * @author lpc
 * @version 1.0  2020-11-27-17:00
 * @since 2020-11-27-17:00
 * 描述：更新代理类并初始化代理容器
 */
public class AgencyUpdate {

    public static AgencyProviderContainer providerContainer;


    /**
     * 更新容器内的对象为代理对象
     *
     * @param container 容器
     */
    public static void update(Container<Object> container) {
        // 提取代理容器
        providerContainer = new AgencyProviderContainer(container);
        // 获取全部对象
        Set<Map.Entry<String, Object>> entries = container.getContainer().entrySet();
        // 遍历对象
        for (Map.Entry<String, Object> element : entries) {
            // 如果有代理对象
            if (element.getValue().getClass().isAnnotationPresent(AgencyProxyClass.class)) {
                // 获取代理类
                Object proxyInstance = AgencyProxyBuild.getProxyInstance(element.getValue());

                // 更新对象组
                container.updateInstance(element.getKey(), proxyInstance);
            }
        }
    }

    /**
     * 获取代理提供者 ！必须先初始化！！！！
     *
     * @return 代理提供者
     */
    public static AgencyProviderContainer getProviderContainer() {
        return providerContainer;
    }
}
