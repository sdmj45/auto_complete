package com.mj.auto_complete.service

/**
  * Created by fjim on 26/04/2017.
  */
trait Service {

  /**
    * insert word in the tree
    * @param word
    * @return
    */
  def insert(word: String): Service

  /**
    * check if word exists in the tree
    * @param word
    * @return
    */
  def exists(word: String): Boolean

  /**
    * auto complete with the prefix
    * @param word
    * @return
    */
  def autoComplete(word: String): List[String]

  /**
    * clear all nodes in the tree
    */
  def clear(): Unit

}
