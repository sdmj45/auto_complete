package com.mj.auto_complete

import java.util.Scanner

import com.mj.auto_complete.app.AutoComplete
import com.mj.auto_complete.business.TernarySearchTree

/**
  * Created by fjim on 25/04/2017.
  */
object App {
  def main(args: Array[String]): Unit = {
    val scan = new Scanner(System.in)

    val autoComplete = AutoComplete(new TernarySearchTree)
    println("Auto complete test\n")
    var ch: Char = 'e'
    do {
      println("\nTernary Search Tree Operations\n")
      println("1. insert word")
      println("2. search word")
      println("3. delete word")
      println("4. check empty")
      println("5. make empty")
      scan.nextInt match {
        case 1 => {
          println("enter word to insert")
          autoComplete.insert(scan.next())
        }
        case 2 => {
          println("enter word to search")
          val result = autoComplete.search(scan.next()) match {
            case true => "word exists"
            case _ => "word does not exist"
          }
          println(result)
        }
      }
      println("\nDo you want to continue (Type y or n) \n")
      ch = scan.next.charAt(0)
    } while (ch == 'Y' || ch == 'y')
  }
}
