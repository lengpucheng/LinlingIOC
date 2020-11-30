package cn.hll520.io.linling.ioc.util.impl;

import cn.hll520.io.linling.ioc.util.LoadFile;

import java.io.File;
import java.util.List;

/**
 * @author lpc
 * @version 1.0  2020-11-26-16:57
 * @since 2020-11-26-16:57
 * 描述：
 */
public class LoadFileJAR implements LoadFile {
    @Override
    public List<File> loadFile(File file) {
        return null;
    }

    @Override
    public List<File> loadFile(String packPath) {
        return null;
    }

    @Override
    public List<String> loadFileUrl(File file) {
        return null;
    }

    @Override
    public List<String> loadFileUrl(String packPath) {
        return null;
    }
}
