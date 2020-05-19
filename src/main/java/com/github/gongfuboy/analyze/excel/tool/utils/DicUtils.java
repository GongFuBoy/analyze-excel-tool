package com.github.gongfuboy.analyze.excel.tool.utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by GongFuBoy on 2020/5/19.
 */
public class DicUtils {


    public static void main(String[] args) {

    }

    /**
     * 重写city.txt文件
     */
    private void rewriteCityFile() throws Exception {
        File file = new File("city.txt");
        List<String> strings = IOUtils.readLines(new FileInputStream(file));
    }

}
