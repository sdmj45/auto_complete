package com.mj.auto_complete.model

/**
  * Created by M on 23/04/2017.
  */
case class Node(data: Char, var isEnd: Boolean, var left: Option[Node], var middle: Option[Node], var right: Option[Node])
