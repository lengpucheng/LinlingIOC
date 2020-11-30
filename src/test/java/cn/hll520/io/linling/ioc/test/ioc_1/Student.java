package cn.hll520.io.linling.ioc.test.ioc_1;

import cn.hll520.io.linling.aop.annotation.AgencyProxy;
import cn.hll520.io.linling.aop.annotation.AgencyProxyClass;
import cn.hll520.io.linling.ioc.annotation.Module;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-14:10
 * @since 2020-11-30-14:10
 * 描述：
 */
@AgencyProxyClass
//    @Module
public class Student implements Person {

    @AgencyProxy("person@001")
    public void say() {
        System.out.println("i m a s t u d!");
    }

    @Override
    public int getAge() {
        return 50;
    }

    @AgencyProxy("person@002")
    @Override
    public String call(int phone) {
        return "my call" + phone + " ";
    }
}
