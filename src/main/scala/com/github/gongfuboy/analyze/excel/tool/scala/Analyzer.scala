package com.github.gongfuboy.analyze.excel.tool.scala

import org.ansj.splitWord.analysis.DicAnalysis

import scala.jdk.CollectionConverters._

/**
  * Created by GongFuBoy on 2020/5/19.
  */
class Analyzer {

  def analyzeCity(sourceString: java.lang.String): java.lang.String = {
    val result = DicAnalysis.parse(sourceString)
    val maybeInt = result.getTerms.asScala.zipWithIndex.find(temp => temp._1.getNatureStr.equals("mark1")).map(_._2)
    if (maybeInt.isEmpty) return ""
    val xianRenMarkWordIndex = maybeInt.getOrElse(result.getTerms.size())
    val xianRenTermList = result.getTerms.asScala.zipWithIndex.filter({
      case (_, index) =>
        index >= xianRenMarkWordIndex
    }).map(_._1)
    if (xianRenTermList.isEmpty) return ""
    val zhiweiMarkWordIndex: Int = xianRenTermList.zipWithIndex.find({
      case (term, _) => term.getNatureStr.equals("mark2")
    }).map(_._2).getOrElse(xianRenTermList.size)
    val zhiweiTermList = result.getTerms.asScala.zipWithIndex.filter({
      case (_, index) => index >= zhiweiMarkWordIndex
    }).map(_._1)
    zhiweiTermList.find(termWord => termWord.getNatureStr.equals("city")).map(_.getName).getOrElse("")
  }


}