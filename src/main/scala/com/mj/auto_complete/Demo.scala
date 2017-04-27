package com.mj.auto_complete

import java.util.Scanner

import com.mj.auto_complete.component.ComponentRegistry

import scala.util.Try

/**
  * Created by fjim on 25/04/2017.
  */
object Demo extends App {
  val scan = new Scanner(System.in).useDelimiter("\\s*\\n\\s*")
  val app = ComponentRegistry.app
  do {
    printHeader()
    Try(scan.next().toInt) getOrElse 0 match {
      case 1 => insertWords()
      case 2 => searchWord()
      case 3 => autoCompletation()
      case _ => println("wrong entry")
    }
    println("\nDo you want to continue (Type quit to exit, anything else to continue) \n")
  } while (!scan.next().equals("quit"))


  private def printHeader() = {
    println(
      """Auto complete Operations ( enter the number to choose )
        |1. insert word(if multiple, separated by comma)
        |2. search word
        |3. auto complete suggestion
      """.stripMargin)
  }

  private def autoCompletation() = {
    println("enter prefix to get auto complete suggestions")
    val results = app.autoComplete(scan.next).mkString(", ")
    println(s"results found: $results")
  }

  private def searchWord() = {
    println("enter word to search")
    val result = if (app.search(scan.next()))
      "word exists"
    else
      "word does not exist"
    println(result)
  }

  private def insertWords() = {
    println("enter words to insert(if multiple, separated by comma)")
    app.insert(scan.next.split(",") toList)
  }
}
