package cn.hll520.io.linling.aop.agency;

import java.lang.reflect.Proxy;

/**
 * @author lpc
 * @version 1.0  2020-11-27-16:41
 * @since 2020-11-27-16:41
 * 描述：代理类分配
 */
public class AgencyProxyBuild {
    public static Object getProxyInstance(Object proxy) {
        // 判断代理类的类型
        if (proxy.getClass().getInterfaces().length <= 0)
            return proxyMean(proxy); // 如果是普通的类
        else
            return proxyInterface(proxy);  // 如果是接口实现类
    }


    /**
     * 构造接口实现类
     *
     * @param proxy 接口实现的被代理类
     * @return 代理类
     */
    private static Object proxyInterface(Object proxy) {
        // 使用被代理对象构造代理类的构造类
        AgencyProxyBuildInterface agencyBuild = new AgencyProxyBuildInterface();
        agencyBuild.setObject(proxy);
        // 使用被代理类的类加载器和实现接口 用代理类 构建一个实例
        return Proxy.newProxyInstance(proxy.getClass().getClassLoader(), proxy.getClass().getInterfaces(), agencyBuild);
    }

    /**
     * 构造普通类
     *
     * @param proxy 被代理类
     * @return 代理类
     */
    private static Object proxyMean(Object proxy) {
        // 使用被代理对象构造代理类的构造类
        AgencyProxyBuildMean agencyBuild = new AgencyProxyBuildMean(proxy);
        return agencyBuild.invoke();
    }
}
