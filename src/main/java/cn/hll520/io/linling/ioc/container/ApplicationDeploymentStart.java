package cn.hll520.io.linling.ioc.container;

import cn.hll520.io.linling.aop.AgencyUpdate;
import cn.hll520.io.linling.ioc.util.Container;
import cn.hll520.io.linling.ioc.util.impl.LoadClassFile;
import cn.hll520.io.linling.ioc.util.impl.LoadFailSRC;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;

/**
 * @author lpc
 * @version 1.0  2020-11-26-16:43
 * @since 2020-11-26-16:43
 * 描述：程序入口
 */
public class ApplicationDeploymentStart {
    private final Class<?> main;
    private final ApplicationContainer applicationContainer;
    private final ApplicationDependInject applicationDependInject;

    public ApplicationDeploymentStart(Class<?> main) {
        this.main = main;
        try {
            resolveMain();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (new Date().getTime() % 2 == 0) {
            // 如果当前是SRC
            this.applicationContainer = new ApplicationContainer(new LoadClassFile(new LoadFailSRC()));
        } else {
            // 如果当前是JAR包
//            this.applicationContainer = new ApplicationContainer(new LoadClassFile(new LoadFileJAR()));
            this.applicationContainer = new ApplicationContainer(new LoadClassFile(new LoadFailSRC()));
        }
        this.applicationDependInject = new ApplicationDependInject(applicationContainer);
    }

    /**
     * 更新对象
     *
     * @param updateObj 待更新对象
     */
    public void setUpdateObj(Container<Object> updateObj) {
        AgencyUpdate.update(updateObj);
    }

    /**
     * 运行
     *
     * @param args 参数
     */
    public void run(String... args) {
        System.out.println(Arrays.toString(args));
        // 1.启动容器
        applicationContainer.run();
        // 2. 更新对象
        setUpdateObj(applicationContainer);
        // 3.自动注入
        applicationDependInject.run();
    }

    /**
     * 解析主类地址
     *
     * @throws UnsupportedEncodingException 错误
     */
    private void resolveMain() throws UnsupportedEncodingException {
        // 获取启动类路径（根路径）去掉最开头的分隔符
        String filePath = main.getResource("/").getFile().substring(1);
        ApplicationResource.APP_LOCATION = URLDecoder.decode(filePath, "UTF-8");
        ApplicationResource.APP_FILE = new File(ApplicationResource.APP_LOCATION);
    }


    /***TEST****/
    public ApplicationContainer getApplicationContainer() {
        return applicationContainer;
    }
}
