package com.github.gongfuboy.analyze.excel.tool.scala

import org.ansj.domain.Result
import org.ansj.splitWord.analysis.DicAnalysis

import scala.collection.JavaConversions._

/**
  * Created by GongFuBoy on 2020/5/19.
  */
class Analyzer {

  def analyzeCity(sourceString: java.lang.String, dicAnalysis: DicAnalysis): java.lang.String = {
    val result: Result = dicAnalysis.parseStr(sourceString)
    val maybeInt = result.getTerms.toList.zipWithIndex.find(temp => temp._1.getName.equals("mark1")).map(_._2)
    val xianRenMarkWordIndex = maybeInt.getOrElse(result.getTerms.size())
    val xianRenTermList = result.getTerms.toList.subList(xianRenMarkWordIndex, result.getTerms.size())
    ""
  }


}

object Analyzer {

  def main(args: Array[String]): Unit = {
    println(List(1, 2, 3).subList(3, 3))
  }

}