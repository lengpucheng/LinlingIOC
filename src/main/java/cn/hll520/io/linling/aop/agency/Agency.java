package cn.hll520.io.linling.aop.agency;


/**
 * @author lpc
 * @version 1.0  2020-11-27-16:26
 * @since 2020-11-27-16:26
 * 描述：代理执行方法的接口
 */
public interface Agency {
    /**
     * 之前执行的代理，前制参数
     *
     * @param pram 原方法入参
     */
    void before(Object... pram);

    /**
     * 周执行的代理
     *
     * @param rest 原方法结果
     * @param pram 原方法入参
     */
    void after(Object rest, Object... pram);
}
