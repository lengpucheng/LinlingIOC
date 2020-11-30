package cn.hll520.io.linling.aop.agency;

import cn.hll520.io.linling.aop.annotation.AgencyProxy;

import java.lang.reflect.Method;

/**
 * @author lpc
 * @version 1.0  2020-11-27-16:02
 * @since 2020-11-27-16:02
 * 描述：普通类的代理
 */
public class AgencyProxyBuildMean {
    private final Object proxied;

    public AgencyProxyBuildMean(Object proxy) {
        this.proxied = proxy;
    }

    public Object invoke() {
        return proxied;
    }
}
