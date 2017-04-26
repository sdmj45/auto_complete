package com.mj.auto_complete

import java.util.Scanner

import com.mj.auto_complete.app.AutoComplete
import com.mj.auto_complete.business.PrefixSearch

import scala.util.Try

/**
  * Created by fjim on 25/04/2017.
  */
object Demo {

  def main(args: Array[String]): Unit = {
    val scan = new Scanner(System.in).useDelimiter("\\s*\\n\\s*")
    val autoComplete = AutoComplete(new PrefixSearch)
    do {
      printHeader()
      Try(scan.next().toInt) getOrElse 0 match {
        case 1 => insertWords(scan, autoComplete)
        case 2 => searchWord(scan, autoComplete)
        case 3 => autoCompletation(scan, autoComplete)
        case _ => println("wrong entry")
      }
      println("\nDo you want to continue (Type quit to exit) \n")
    } while (!scan.next().equals("quit"))
  }

  private def printHeader() = {
    println(
      """Auto complete Operations ( enter the number to choose )
        |1. insert word(if multiple, separated by comma)
        |2. search word
        |3. auto complete suggestion
      """.stripMargin)
  }

  private def autoCompletation(scan: Scanner, autoComplete: AutoComplete) = {
    println("enter prefix to get auto complete suggestions")
    val results = autoComplete.autocomplete(scan.next).mkString(", ")
    println(s"results found: $results")
  }

  private def searchWord(scan: Scanner, autoComplete: AutoComplete) = {
    println("enter word to search")
    val result = if (autoComplete.search(scan.next()))
      "word exists"
    else
      "word does not exist"
    println(result)
  }

  private def insertWords(scan: Scanner, autoComplete: AutoComplete) = {
    println("enter words to insert(if multiple, separated by comma)")
    autoComplete.insert(scan.next.split(",") toList)
  }
}
