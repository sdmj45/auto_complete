package com.mj.auto_complete.app

import com.mj.auto_complete.business.Insert.InsertLike
import com.mj.auto_complete.business.{PrefixSearch, Search}
import com.mj.auto_complete.model.{Node, PrefixNode}

/**
  * Created by fjim on 24/04/2017.
  */

trait Application {

  import scalaz.Reader

  private var node: Node = _

  def insert[T](word: T)(implicit env: InsertLike[T]): Application = {
    this.node = env.insert(word)
    this
  }

  /*  def insert(word: String): AutoComplete = {
      this.node = tst.insert(Some(node), word.toList, 0)
      this
    }

    def insert(words: List[String]): AutoComplete = {
      words.foreach(w => this.insert(w))
      this
    }*/

  def search(word: String) = Reader((search: Search) =>
    search.search(word)
  )

  //    tst.search(Some(node), word.toList, 0)

  def autocomplete(word: String) = Reader((search: Search) =>
    search.autoComplete(word)
  )

  //    tst.autocomplete(Some(node), prefix)
}
