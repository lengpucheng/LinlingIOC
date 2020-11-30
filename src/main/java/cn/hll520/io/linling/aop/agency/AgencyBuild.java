package cn.hll520.io.linling.aop.agency;

import cn.hll520.io.linling.aop.AgencyUpdate;
import cn.hll520.io.linling.aop.annotation.AgencyProviderMethod;
import cn.hll520.io.linling.aop.annotation.util.AgencyProviderInstance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lpc
 * @version 1.0  2020-11-27-16:27
 * @since 2020-11-27-16:27
 * 描述：获取或构造代理执行方法
 */
public class AgencyBuild {
    private final String agencyID;
    // 临时存储方法
    private final List<Method> before = new ArrayList<>();
    // 临时存储方法
    private final List<Method> after = new ArrayList<>();

    public AgencyBuild(String agencyID) {
        this.agencyID = agencyID;
    }

    public Agency getAgency() {
        // 获取代理
        AgencyProviderInstance instance = AgencyUpdate.getProviderContainer().getInstance(agencyID);

        // 如果代理不启用 返回空代理即可
        if (instance == null || !instance.isEnable())
            return blank();

        // 获取服务实例
        final Object proxy = instance.getInstance();

        // 如果代理类直接实现于Agency 就可以直接返回 agency
        if (proxy instanceof Agency)
            return (Agency) proxy;
        else
            return getAgencyMean(proxy);
    }

    /**
     * 获取非实现接口的代理类
     *
     * @param proxy 代理类
     * @return 标准的Agency接口对象
     */
    private Agency getAgencyMean(final Object proxy) {
        // 初始化普通代理类的方法
        getMethod(proxy);
        // 构造代理方法
        return new Agency() {
            @Override
            public void before(Object... pram) {
                System.out.println("____AGENCY_LINLING_" + agencyID + "___START___");
                try {
                    // 从集合中取出
                    for (Method method : before) {
                        // 获取参数
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        // 根据参数执行
                        if (parameterTypes == null || parameterTypes.length == 0) {
                            method.invoke(proxy);
                        } else
                            method.invoke(proxy, pram);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void after(Object rest, Object... pram) {
                try {
                    // 从集合中取出
                    for (Method method : after) {
                        // 获取参数
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        // 根据参数执行
                        if (parameterTypes != null)
                            switch (parameterTypes.length) {
                                case 0:
                                    method.invoke(proxy);
                                    break;
                                case 1:
                                    method.invoke(proxy, rest);
                                    break;
                                default:
                                    method.invoke(proxy, rest, pram);
                                    break;
                            }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("____AGENCY_LINLING_" + agencyID + "___END___");
            }
        };
    }

    /**
     * 初始化普通代理类的方法，并按参数将其添加到集合
     *
     * @param proxy 代理对象
     */
    private void getMethod(Object proxy) {
        // 如果非继承Agency 构造一个Agency
        Class<?> proxyClass = proxy.getClass();
        // 获取全部方法
        Method[] methods = proxyClass.getMethods();

        // 遍历判断
        for (Method method : methods) {
            AgencyProviderMethod annotation = method.getAnnotation(AgencyProviderMethod.class);
            // 如果改注解不为空
            if (null != annotation) {
                // 感觉其参数添加到集合添加到集合
                switch (annotation.value()) {
                    case BEFORE:
                        before.add(method);
                        break;
                    case AFTER:
                        after.add(method);
                        break;
                    case ALL:
                    case MEANWHILE:
                    case BEFORE_AND_AFTER:
                        before.add(method);
                        after.add(method);
                        break;
                }
            }
        }
    }

    /**
     * 一个空的代理
     *
     * @return 空的
     */
    private Agency blank() {
        return new Agency() {
            @Override
            public void before(Object... pram) {
                System.out.println("____AGENCY_LINLING_" + agencyID + "___START___");
            }

            @Override
            public void after(Object rest, Object... pram) {
                System.out.println("____AGENCY_LINLING_" + agencyID + "___END___");
            }
        };
    }
}
