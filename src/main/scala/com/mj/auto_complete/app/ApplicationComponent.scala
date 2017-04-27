package com.mj.auto_complete.app

import com.mj.auto_complete.component.ServiceComponent
import com.mj.auto_complete.utils.Insert.InsertLike

/**
  * Created by fjim on 25/04/2017.
  */
trait ApplicationComponent {
  this: ServiceComponent =>

  val app: Application

  class Application {

    def insert[T](word: T)(implicit env: InsertLike[T]): Application = {
      env.insert(word, service)
      this
    }

    def search(word: String): Boolean = service.exists(word)

    def autoComplete(word: String): List[String] = service.autoComplete(word)

    def clear(): Application = {
      service.clear()
      this
    }
  }

}
