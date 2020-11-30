package cn.hll520.io.linling.aop.annotation;

/**
 * @author lpc
 * @version 1.0  2020-11-27-15:40
 * @since 2020-11-27-15:40
 * 描述：
 */
public enum AgencyPoint {
    BEFORE, // 之前
    AFTER, // 之后
    BEFORE_AND_AFTER, // 前后
    ALL,// 全部(同上)
    MEANWHILE; // 同时（同步）
}
