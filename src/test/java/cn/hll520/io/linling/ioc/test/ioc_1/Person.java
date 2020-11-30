package cn.hll520.io.linling.ioc.test.ioc_1;

import cn.hll520.io.linling.aop.annotation.AgencyProxy;
import cn.hll520.io.linling.aop.annotation.AgencyProxyClass;
import cn.hll520.io.linling.ioc.annotation.Module;

/**
 * @author lpc
 * @version 1.0  2020-11-27-10:47
 * @since 2020-11-27-10:47
 * 描述：
 */
@Module
public interface Person {
    void say();
    int getAge();
    String call(int phone);

}
