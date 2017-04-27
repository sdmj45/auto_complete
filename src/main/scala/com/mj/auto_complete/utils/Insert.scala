package com.mj.auto_complete.utils

import com.mj.auto_complete.service.Service

/**
  * Created by fjim on 26/04/2017.
  * 
  * type class used to authorize insertion of word and list of words
  */
object Insert{

  sealed trait InsertLike[T] {
    def insert(t: T, service: Service): Unit
  }

  object InsertLike {

    implicit object InsertSingleWord extends InsertLike[String] {
      override def insert(t: String, service: Service): Unit = service.insert(t)
    }

    implicit object InsertListWords extends InsertLike[List[String]] {
      override def insert(t: List[String], service: Service): Unit = t.foreach(w => service.insert(w))
    }

  }
}
