package com.mj.auto_complete.business

import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 24/04/2017.
  */
class TernarySearchTree {
  def insert(node: Option[Node], word: List[Char], position: Int): Node = {
    def insertMiddle(nd: Node) =
      if (position + 1 < word.length)
        nd.middle = Some(insert(nd.middle, word, position + 1))
      else
        nd.isEnd = true

    if (node isEmpty) {
      //create new node
      val nd = Node(word(position))
      insertMiddle(nd)
      nd
    } else {
      //node exists
      word(position) match {
        case p if p < node.get.data => node.get.left = Some(insert(node.get.left, word, position))
        case p if p > node.get.data => node.get.right = Some(insert(node.get.right, word, position))
        case _ => insertMiddle(node.get)
      }
      node.get
    }
  }
}
