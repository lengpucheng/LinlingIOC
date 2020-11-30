package cn.hll520.io.linling.ioc.util;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * @author lpc
 * @version 1.0  2020-11-26-15:06
 * @since 2020-11-26-15:06
 * 描述： 文件和类加载
 */
public interface LoadClass {

    /**
     * 从指定文件集加载全部类和类名
     *
     * @param urlList 路径集
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(List<String> urlList);

    /**
     * 从指定文件集加载含有指定注释的类和类名
     *
     * @param urlList    路径集
     * @param annotation 指定注释
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(List<String> urlList, Class<? extends Annotation> annotation);

    /**
     * 从指定文件加载路径下全部类和类名
     *
     * @param file 文件路径
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(File file);

    /**
     * 从指定文件加载路径下含有指定注释的类和类名
     *
     * @param file       路径集
     * @param annotation 指定注释
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(File file, Class<? extends Annotation> annotation);

    /**
     * 从指定包路径加载路径下全部类和类名
     *
     * @param packPath 包路径
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(String packPath);

    /**
     * 从指定包路径下加载含有指定注释的类和类名
     *
     * @param packPath   包径集
     * @param annotation 指定注释
     * @return 全类名和类的 k-v对
     */
    Map<String, Class<?>> loadClass(String packPath, Class<? extends Annotation> annotation);

}
