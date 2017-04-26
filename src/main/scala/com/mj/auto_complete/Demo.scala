package com.mj.auto_complete

import java.util.Scanner

import com.mj.auto_complete.app.Application
import com.mj.auto_complete.business.PrefixSearch

import scala.util.Try

/**
  * Created by fjim on 25/04/2017.
  */
object Demo extends Application{

  def test(w:String)={
    for{
      node<-
    }
  }

  def main(args: Array[String]): Unit = {
    for{
      node<-search("jj")
    }










    val scan = new Scanner(System.in).useDelimiter("\\s*\\n\\s*")
    val autoComplete = Application(new PrefixSearch)

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

  private def autoCompletation(scan: Scanner, autoComplete: Application) = {
    println("enter prefix to get auto complete suggestions")
    val results = autoComplete.autocomplete(scan.next).mkString(", ")
    println(s"results found: $results")
  }

  private def searchWord(scan: Scanner, autoComplete: Application) = {
    println("enter word to search")
    val result = if (autoComplete.search(scan.next()))
      "word exists"
    else
      "word does not exist"
    println(result)
  }

  private def insertWords(scan: Scanner, autoComplete: Application) = {
    println("enter words to insert(if multiple, separated by comma)")
    autoComplete.insert(scan.next.split(",") toList)
  }
}
