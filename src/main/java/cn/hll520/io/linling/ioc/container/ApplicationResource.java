package cn.hll520.io.linling.ioc.container;

import java.io.File;

/**
 * @author lpc
 * @version 1.0  2020-11-26-15:16
 * @since 2020-11-26-15:16
 * 描述：存储和其相关的常量
 */
public class ApplicationResource {
    protected static String APP_LOCATION;
    protected static File APP_FILE;

    public static String getAppLocation() {
        return APP_LOCATION;
    }

    public static File getAppFile() {
        return APP_FILE;
    }
}
