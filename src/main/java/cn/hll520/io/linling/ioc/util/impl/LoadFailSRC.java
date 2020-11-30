package cn.hll520.io.linling.ioc.util.impl;

import cn.hll520.io.linling.ioc.container.ApplicationResource;
import cn.hll520.io.linling.ioc.util.LoadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lpc
 * @version 1.0  2020-11-26-16:57
 * @since 2020-11-26-16:57
 * 描述：
 */
public class LoadFailSRC implements LoadFile {
    @Override
    public List<File> loadFile(File file) {
        List<File> fileList = new ArrayList<>();
        cycleLoadFile(file, fileList);
        return fileList;
    }

    @Override
    public List<File> loadFile(String packPath) {
        return loadFile(new File(ApplicationResource.getAppLocation() + packPath.replace('.', File.separatorChar)));
    }

    @Override
    public List<String> loadFileUrl(File file) {
        // 获取当前路径下的全部文件路径
        List<File> fileList = loadFile(file);
        // 初始化类集合
        List<String> loadCompleteClassList = new ArrayList<>();
        // 获取根节点路径的长度
        int root = ApplicationResource.getAppLocation().length();
        // 遍历路径集
        for (File element : fileList) {
            // 替换为.路径
            String filePath = element.getPath().replace(File.separatorChar, '.');
            // 判断若是class结尾的类
            if (filePath.endsWith(".class")) {
                // 去掉根前缀，取包名.类名 并加入节点
                String className = filePath.substring(root, filePath.lastIndexOf(".class"));
                loadCompleteClassList.add(className);
            }
        }
        return loadCompleteClassList;
    }

    @Override
    public List<String> loadFileUrl(String packPath) {
        return loadFileUrl(new File(ApplicationResource.getAppLocation() + packPath.replace('.', File.separatorChar)));
    }

    private void cycleLoadFile(File file, List<File> fileList) {
        if (file == null)
            return;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null)
                for (File element : files)
                    cycleLoadFile(element, fileList);
        } else
            fileList.add(file);
    }
}
