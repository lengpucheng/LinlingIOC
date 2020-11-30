package cn.hll520.io.linling.ioc.test.ioc_1;

import cn.hll520.io.linling.aop.annotation.AgencyPoint;
import cn.hll520.io.linling.aop.annotation.AgencyProvider;
import cn.hll520.io.linling.aop.annotation.AgencyProviderMethod;

import java.util.Date;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-15:30
 * @since 2020-11-30-15:30
 * 描述：
 */
@AgencyProvider("person@002")
public class PAgency {
    @AgencyProviderMethod(AgencyPoint.BEFORE)
    public void say(int call){
        System.out.println(new Date());
        System.out.println(call);
    }
}
