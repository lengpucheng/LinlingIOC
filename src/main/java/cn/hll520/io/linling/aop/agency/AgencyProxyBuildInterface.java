package cn.hll520.io.linling.aop.agency;

import cn.hll520.io.linling.aop.annotation.AgencyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lpc
 * @version 1.0  2020-11-27-16:02
 * @since 2020-11-27-16:02
 * 描述：接口类的代理
 */
public class AgencyProxyBuildInterface implements InvocationHandler {
    private Object agency; // 被代理的对象

    public void setObject(Object agency) {
        this.agency = agency;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取被代理对象的方法
        Method origin = getMethod(method);

        // 判断是否有注释需要代理
        AgencyProxy agencyProxy = origin.getAnnotation(AgencyProxy.class);
        Object invoke;
        if (agencyProxy == null)
            invoke = method.invoke(agency, args);  // 如果没有代理注解就直接执行方法
        else {
            // 获取代理ID
            String value = agencyProxy.value();

            // 根据代理ID获取代理方法
            Agency agencyPoxy = new AgencyBuild(value).getAgency();

            // 之前
            agencyPoxy.before(args);

            // 原方法
            invoke = method.invoke(agency, args);

            // 之后
            agencyPoxy.after(invoke, args);
        }

        // 返回原来的结果
        return invoke;
    }


    /**
     * 感觉参数个数获取真实的对象的代理方法
     *
     * @param method 方法
     * @return 对象的代理方法
     * @throws NoSuchMethodException 错误
     * @throws SecurityException     错误
     */
    public Method getMethod(Method method) throws NoSuchMethodException, SecurityException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 如果没有参数
        if (parameterTypes.length == 0)
            return agency.getClass().getDeclaredMethod(method.getName());
        // 如果有参数
        return agency.getClass().getDeclaredMethod(method.getName(), parameterTypes);

    }

}

