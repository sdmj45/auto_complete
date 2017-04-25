package com.mj.auto_complete.app

import com.mj.auto_complete.business.TernarySearchTree
import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 24/04/2017.
  */
object AutoComplete {
  def apply(tst: TernarySearchTree) = new AutoComplete(tst)
}

class AutoComplete(tst: TernarySearchTree) {
  private var node: Node = _

  def insert(word: String): AutoComplete = {
    this.node = tst.insert(Some(node), word.toList, 0)
    this
  }

  def insert(words: List[String]): AutoComplete = {
    words.foreach(w => this.insert(w))
    this
  }

  def search(word: String): Boolean =
    tst.search(Some(node), word.toList, 0)

  def autocomplete(prefix: String): List[String] =
    tst.autocomplete(Some(node), prefix)
}
