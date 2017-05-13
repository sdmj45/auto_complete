package com.mj.auto_complete.model

/**
  * Created by M on 25/04/2017.
  */
case class Node(var data: Char,
                var isEnd: Boolean = false,
                var left: Option[Node] = None,
                var middle: Option[Node] = None,
                var right: Option[Node] = None)
