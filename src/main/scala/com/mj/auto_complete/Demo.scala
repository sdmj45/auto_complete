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
      case 1 => autoCompleteWithElementsGiven()
      case 2 => insertWords()
      case 3 => exists()
      case 4 => autoComplexation()
      case 5 => clear()
      case _ => println("wrong entry")
    }
    println("\nDo you want to continue (Type quit to exit, anything else to continue) \n")
  } while (!scan.next().equals("quit"))


  private def printHeader() = {
    println(
      """Auto complete Operations ( enter the number to choose )
        |1. test auto complete only with the elements given ("Pandora", "Pinterest", "Paypal"...)
        |2. insert word(if multiple, separated by comma)
        |3. check word exists
        |4. auto complete suggestion
        |5. clear the memory
      """.stripMargin)
  }

  private def autoCompleteWithElementsGiven() = {
    lazy val insertList = List("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria"
      , "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe")
    app clear() insert insertList
    autoComplexation()
  }

  private def clear() = {
    println("you want to clear the node?(y/n)")
    if (scan.next().equals("y"))
      app.clear()
  }


  private def autoComplexation() = {
    println("enter prefix to get auto complete suggestions")
    val list = app.autoComplete(scan.next)
    if (list isEmpty)
      println("no result found")
    else
      println(s"results found: ${list.mkString(", ")}")
  }

  private def exists() = {
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
