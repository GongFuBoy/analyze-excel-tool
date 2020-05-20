package com.github.gongfuboy.analyze.excel.tool;

import com.github.gongfuboy.analyze.excel.tool.scala.Analyzer;
import org.ansj.library.DicLibrary;
import org.ansj.util.MyStaticValue;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.library.Library;

/**
 * Created by GongFuBoy on 2018/9/3.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        initDic();
        Analyzer analyzer = new Analyzer();
        String cityString = analyzer.analyzeCity("现任所长北京市");
        System.out.println(cityString);
    }

    private static void initDic() throws Exception {
        Forest forest = Library.makeForest(Main.class.getClassLoader().getResource("user.dic").getFile());
        DicLibrary.put(DicLibrary.DEFAULT, DicLibrary.DEFAULT, forest);
        MyStaticValue.isNameRecognition = false;
        MyStaticValue.isNumRecognition = false;
        MyStaticValue.isQuantifierRecognition = false;
        MyStaticValue.isRealName = false;
        MyStaticValue.isSkipUserDefine = false;
    }

}
