package cn.hll520.io.linling.aop.annotation.util;

import cn.hll520.io.linling.aop.annotation.AgencyProvider;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-10:31
 * @since 2020-11-30-10:31
 * 描述：AgencyProvider Bean
 */
public class AgencyProviderInstance {
    String id; // proxy ID
    String className; // className
    double version; // 版本
    boolean enable; // 是否启用
    Object instance; // 对象

    public AgencyProviderInstance() {
    }

    public AgencyProviderInstance(AgencyProvider provider) {
        this();
        this.id = provider.value();
        this.version = provider.version();
        this.enable = provider.enable();
    }

    public AgencyProviderInstance(AgencyProvider provider, Object instance) {
        this(provider);
        this.instance = instance;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "AgencyProviderInstance{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", version=" + version +
                ", enable=" + enable +
                ", instance=" + instance +
                '}';
    }
}
