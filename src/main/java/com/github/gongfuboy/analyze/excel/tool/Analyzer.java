package com.github.gongfuboy.analyze.excel.tool;

import org.ansj.domain.Result;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;

/**
 * Created by GongFuBoy on 2020/5/19.
 */
public class Analyzer {

    public static String analyzeCity(String sourceString, DicAnalysis dicAnalysis, DicLibrary dicLibrary) {
        Result terms = dicAnalysis.parseStr(sourceString);
        return null;
    }

}
