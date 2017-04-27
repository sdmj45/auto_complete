package com.mj.auto_complete.service

/**
  * Created by fjim on 26/04/2017.
  */
trait Service {

  def insert(word: String): Unit

  def search(word: String): Boolean

  def autoComplete(word: String): List[String]

}
