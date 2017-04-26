package com.mj.auto_complete.model

/**
  * Created by M on 23/04/2017.
  */
case class Node(var data: Char, var isEnd: Boolean = false, var left: Option[Node] = None,
                var middle: Option[Node] = None, var right: Option[Node] = None) extends AbstractNode {

  override def hasChildren: Boolean =
    (left isDefined) || (middle isDefined) || (right isDefined)

  override def remove: Unit = {
    data = '\u0000'
    isEnd = false
    left = None
    right = None
    middle = None
  }
}
