package com.github.gongfuboy.analyze.excel.tool.scala.utils

import java.io.{File, FileInputStream, FileOutputStream}
import java.net.URL

import org.apache.commons.io.IOUtils

import scala.collection.JavaConversions._


/**
 * 相关字典生成工具类
 *
 * Created by GongFuBoy on 2020/5/19.
 */
object DicUtils {

  def main(args: Array[String]): Unit = {
    rewriteCityFile
  }

  private def rewriteCityFile = {
    val url: URL = this.getClass.getClassLoader.getResource("city.txt")
    val stream = new FileInputStream(url.getFile)
    val cityLines = IOUtils.readLines(stream)
    val replacedCityStrings = cityLines.toList.map(cityLine => {
      cityLine.replaceAll("\\d+", "").trim
    })

    val fileDicUrl = url.getFile.replaceAll("city.txt", "city.dic")
    val dicFile = new File(fileDicUrl)
    if (!dicFile.exists()) dicFile.createNewFile()
    IOUtils.writeLines(replacedCityStrings, " " + "city" + " " + "1000" + System.getProperty("line.separator"), new FileOutputStream(dicFile))
  }

}