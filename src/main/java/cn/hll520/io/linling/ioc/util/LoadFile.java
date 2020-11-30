package cn.hll520.io.linling.ioc.util;

import java.io.File;
import java.util.List;

/**
 * @author lpc
 * @version 1.0  2020-11-26-15:50
 * @since 2020-11-26-15:50
 * 描述：
 */
public interface LoadFile {
    /**
     * 从指定文件路径加载路径下全部文件
     *
     * @param file 文件路径
     * @return 文件集
     */
    List<File> loadFile(File file);

    /**
     * 从指定包路径加载路径下全部文件
     *
     * @param packPath 包路径
     * @return 文件集
     */
    List<File> loadFile(String packPath);

    /**
     * 从指定文件加载文件下全部路径
     *
     * @param file 文件
     * @return 路径集
     */
    List<String> loadFileUrl(File file);

    /**
     * 从指定包下加载文件下全部路径
     *
     * @param packPath 包
     * @return 路径集
     */
    List<String> loadFileUrl(String packPath);
}
