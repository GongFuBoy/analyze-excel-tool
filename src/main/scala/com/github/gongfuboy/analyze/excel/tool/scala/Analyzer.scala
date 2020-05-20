package com.github.gongfuboy.analyze.excel.tool.scala

import org.ansj.domain.Result
import org.ansj.splitWord.analysis.DicAnalysis

import scala.collection.JavaConversions._

/**
  * Created by GongFuBoy on 2020/5/19.
  */
class Analyzer {

  def analyzeCity(sourceString: java.lang.String): java.lang.String = {
    val result = DicAnalysis.parse(sourceString)
    val maybeInt = result.getTerms.toList.zipWithIndex.find(temp => temp._1.getNatureStr.equals("mark1")).map(_._2)
    if (maybeInt.isEmpty) return ""
    val xianRenMarkWordIndex = maybeInt.getOrElse(result.getTerms.size())
    val xianRenTermList = result.getTerms.toList.subList(xianRenMarkWordIndex, result.getTerms.size())
    if (xianRenTermList.isEmpty) return ""
    val zhiweiMarkWordIndex: Int = xianRenTermList.toList.zipWithIndex.find({
      case (term, _) => term.getNatureStr.equals("mark2")
    }).map(_._2).getOrElse(xianRenTermList.size())
    val zhiweiTermList = result.getTerms.toList.subList(zhiweiMarkWordIndex, result.getTerms.size())
    zhiweiTermList.toList.find(termWord => termWord.getNatureStr.equals("city")).map(_.getName).getOrElse("")
  }


}