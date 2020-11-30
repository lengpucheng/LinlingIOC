package cn.hll520.io.linling;

import cn.hll520.io.linling.ioc.container.ApplicationDeploymentStart;

/**
 * @author lpc
 * @version 1.0  2020-11-26-9:48
 * @since 2020-11-26-9:48
 * 描述：入口
 */

public class LinLingApplicationMain {

    public static void main(String[] args) {
        new ApplicationDeploymentStart(LinLingApplicationMain.class).run(args);
    }
}
