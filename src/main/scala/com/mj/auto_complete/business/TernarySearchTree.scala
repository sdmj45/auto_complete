package com.mj.auto_complete.business

import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 24/04/2017.
  */
class TernarySearchTree {
  var res: List[String] = List()

  def insert(node: Option[Node], word: List[Char], position: Int): Node = {
    def insertMiddle(nd: Node) =
      if (position + 1 < word.length)
        nd.middle = Some(insert(nd.middle, word, position + 1))
      else
        nd.isEnd = true

    if ((node isEmpty) || node.get == null) {
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

  def search(node: Option[Node], word: List[Char], position: Int): Boolean = {
    if (node isEmpty)
      false
    else {
      word(position) match {
        case p if p < node.get.data => search(node.get.left, word, position)
        case p if p > node.get.data => search(node.get.right, word, position)
        case _ =>
          if (node.get.isEnd && position + 1 == word.length) true
          else if (position + 1 == word.length) false
          else search(node.get.middle, word, position + 1)
      }
    }
  }

  /*  def delete(node: Option[Node], word: List[Char], position: Int): Unit = {
      if (node isDefined) {
        if (!node.get.hasChildren)
          node.get.remove
        else {
          if (word(position) < node.get.data) {
            delete(node.get.left, word, position)
          } else if (word(position) > node.get.data) {
            delete(node.get.right, word, position)
          } else {
            //delete
            if (position + 1 == word.length) {
              if (node.get.hasChildren)
                node.get.isEnd = false
              else
                delete(node.get.middle, word, position - 1)
            }
          }
        }
      }
    }*/


  def traverse(node: Option[Node], word: String): List[String] = {
    if (word.length == 0)
      traverseWithoutWord(node, "")
    else
      traverseWithWord(node, word, 0)
    res
  }

  def traverseWithoutWord(node: Option[Node], word: String): Unit = {
    if (node.isDefined && node.get != null) {
      val stringBuilder = new StringBuilder(word)

      if (node.get.left isDefined)
        traverseWithoutWord(node.get.left, stringBuilder.toString())

      stringBuilder.append(node.get.data)
      if (node.get.isEnd)
        res = res :+ stringBuilder.toString()

      if (node.get.middle isDefined)
        traverseWithoutWord(node.get.middle, stringBuilder.toString())

      if (node.get.right isDefined) {
        var str = stringBuilder.toString()
        str = str.substring(0, str.length - 1)
        traverseWithoutWord(node.get.right, str)
      }
    }
  }

  def traverseWithWord(node: Option[Node], word: String, position: Int): Unit = {
    if (node isDefined) {
      if (word.charAt(position) > node.get.data) {
        traverseWithWord(node.get.right, word, position)
      } else if (word.charAt(position) < node.get.data) {
        traverseWithWord(node.get.left, word, position)
      } else {
        //middle ok!
        if (position + 1 < word.length)
          traverseWithWord(node.get.middle, word, position + 1)
        else {
          if (node.get.isEnd)
            res = res :+ word
          traverseWithoutWord(node.get.middle, word)
        }
      }
    }
  }
}
