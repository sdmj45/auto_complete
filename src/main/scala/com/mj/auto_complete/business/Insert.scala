package com.mj.auto_complete.business

import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 26/04/2017.
  */
object Insert{

  sealed trait InsertLike[T] {
    def insert(t: T): Node
  }

  object InsertLike {

    implicit object InsertSingleWord extends InsertLike[String] {
      override def insert(t: String): Node = ???
    }

    implicit object InsertListWords extends InsertLike[List[String]] {
      override def insert(t: List[String]): Node = ???
    }

  }
}


