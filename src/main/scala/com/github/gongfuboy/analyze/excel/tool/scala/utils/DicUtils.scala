package com.github.gongfuboy.analyze.excel.tool.scala.utils

import java.io.{File, FileInputStream, FileOutputStream}
import java.net.URL

import org.apache.commons.io.IOUtils

import scala.jdk.CollectionConverters._


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
    val replacedCityStrings = cityLines.asScala.toList.map(cityLine => {
      cityLine.replaceAll("\\d+", "").trim
    })

    val fileDicUrl = url.getFile.replaceAll("city.txt", "user.dic")
    val dicFile = new File(fileDicUrl)
    if (!dicFile.exists()) dicFile.createNewFile()

    // 写入城市字段
    val fileStream = new FileOutputStream(dicFile)
    IOUtils.writeLines(replacedCityStrings.asJava, "\t" + "city" + "\t" + "1000" + System.getProperty("line.separator"), fileStream)

    // 写入现任标识字段
    val mark1FileUrl = url.getFile.replaceAll("city.txt", "mark1.txt")
    IOUtils.writeLines(IOUtils.readLines(new FileInputStream(mark1FileUrl)), "\t" + "mark1" + "\t" + "1000" + System.getProperty("line.separator"), fileStream)

    // 写入城市标识字段
    val mark2FileUrl = url.getFile.replaceAll("city.txt", "mark2.txt")
    IOUtils.writeLines(IOUtils.readLines(new FileInputStream(mark2FileUrl)), "\t" + "mark2" + "\t" + "1000" + System.getProperty("line.separator"), fileStream)
  }

}