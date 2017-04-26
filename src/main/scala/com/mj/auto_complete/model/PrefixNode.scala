package com.mj.auto_complete.model

/**
  * Created by M on 23/04/2017.
  */
case class PrefixNode(var data: Char,
                      var isEnd: Boolean = false,
                      var left: Option[PrefixNode] = None,
                      var middle: Option[PrefixNode] = None,
                      var right: Option[PrefixNode] = None) extends Node {

  override def hasChildren: Boolean =
    (left isDefined) || (middle isDefined) || (right isDefined)

  override def remove(): Unit = {
    data = '\u0000'
    isEnd = false
    left = None
    right = None
    middle = None
  }
}
