package com.mj.auto_complete.business

/**
  * Created by fjim on 26/04/2017.
  */
trait Search {

  type Node <: Node

  def insert(word: String): Unit

  def search(word: String): Boolean

  def autoComplete(word: String): List[String]

}
