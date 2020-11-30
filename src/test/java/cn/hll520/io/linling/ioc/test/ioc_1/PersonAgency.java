package cn.hll520.io.linling.ioc.test.ioc_1;

import cn.hll520.io.linling.aop.annotation.AgencyProvider;

/**
 * @author lpc lpc@hll520.cn
 * @version 1.0  2020-11-30-13:47
 * @since 2020-11-30-13:47
 * 描述：
 */
@AgencyProvider("person@001")
public class PersonAgency implements cn.hll520.io.linling.aop.agency.Agency {
    @Override
    public void before(Object... pram) {
        System.out.println("person@0001");

    }

    @Override
    public void after(Object rest, Object... pram) {
        System.out.println("student@000001");
    }
}
