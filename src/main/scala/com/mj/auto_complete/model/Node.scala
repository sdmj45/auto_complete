package com.mj.auto_complete.model

/**
  * Created by M on 23/04/2017.
  */
case class Node(data: Char, var isEnd: Boolean = false, var left: Option[Node] = None, var middle: Option[Node] = None, var right: Option[Node] = None)
