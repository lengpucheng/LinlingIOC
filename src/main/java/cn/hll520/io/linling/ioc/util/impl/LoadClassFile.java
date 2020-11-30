package cn.hll520.io.linling.ioc.util.impl;

import cn.hll520.io.linling.ioc.container.ApplicationResource;
import cn.hll520.io.linling.ioc.util.LoadClass;
import cn.hll520.io.linling.ioc.util.LoadFile;
import cn.hll520.io.linling.ioc.util.OperateAnnotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lpc
 * @version 1.0  2020-11-26-16:59
 * @since 2020-11-26-16:59
 * 描述：
 */
public class LoadClassFile implements LoadClass {

    private final LoadFile loadFile;

    public LoadClassFile(LoadFile loadFile) {
        this.loadFile = loadFile;
    }

    @Override
    public Map<String, Class<?>> loadClass(List<String> urlList) {
        return loadClass(urlList, null);
    }

    @Override
    public Map<String, Class<?>> loadClass(List<String> urlList, Class<? extends Annotation> annotation) {
        Map<String, Class<?>> urlClassMap = new HashMap<>();
        // 获取类加载器
        try {
            ClassLoader classLoader = new URLClassLoader(new URL[]{ApplicationResource.getAppFile().toURI().toURL()});
            // 遍历根据路径加载类
            for (String url : urlList) {
                Class<?> clazz = classLoader.loadClass(url);
                // 判断是否有model组件，若有则加入到类加载器中,或没有指定时候全部加入
                if (null == annotation || OperateAnnotation.whetherIncludeAnnotation(clazz, annotation))
                    urlClassMap.put(url, clazz);
            }
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return urlClassMap;
    }

    @Override
    public Map<String, Class<?>> loadClass(File file) {
        return loadClass(file, null);
    }

    @Override
    public Map<String, Class<?>> loadClass(File file, Class<? extends Annotation> annotation) {
        return loadClass(loadFile.loadFileUrl(file), annotation);
    }

    @Override
    public Map<String, Class<?>> loadClass(String packPath) {
        return loadClass(packPath, null);
    }

    @Override
    public Map<String, Class<?>> loadClass(String packPath, Class<? extends Annotation> annotation) {

        return loadClass(loadFile.loadFileUrl(packPath), annotation);
    }
}
