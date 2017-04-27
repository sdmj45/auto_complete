package com.mj.auto_complete.service

import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 25/04/2017.
  */
object PrefixService {
  val MAX_SUGGESTIONS: Int = 4
}

class PrefixService extends Service {

  import PrefixService._

  private var node: Node = _

  /**
    * insert word in the tree
    *
    * @param word
    * @return
    */
  override def insert(word: String): Service = {
    this.node = insert(Option(node), word.toList, 0)
    this
  }

  /**
    * check if word exists in the tree
    *
    * @param word
    * @return
    */
  override def exists(word: String): Boolean =
    exists(Option(node), word.toList, 0)

  /**
    * auto complete with the prefix
    *
    * @param word
    * @return
    */
  override def autoComplete(word: String): List[String] =
    autoComplete(Option(node), word)

  /**
    * clear all nodes in the tree
    */
  override def clear(): Unit = this.node = null

  /**
    * recursive insert
    * @param node
    * @param word
    * @param position
    * @return
    */
  private def insert(node: Option[Node], word: List[Char], position: Int): Node = {
    def insertMiddle(nd: Node) =
      if (position + 1 < word.length)
        nd.middle = Some(insert(nd.middle, word, position + 1))
      else
        nd.isEnd = true

    node match {
      case Some(n) =>
        word(position) match {
          case p if toLowerCase(p) < toLowerCase(n.data) => n.left = Some(insert(n.left, word, position))
          case p if toLowerCase(p) > toLowerCase(n.data) => n.right = Some(insert(n.right, word, position))
          case _ => insertMiddle(n)
        }
        n
      case None =>
        val nd = Node(toLowerCase(word(position)))
        insertMiddle(nd)
        nd
    }
  }

  /**
    * recursive to check if word exists
    * @param node
    * @param word
    * @param position
    * @return
    */
  private def exists(node: Option[Node], word: List[Char], position: Int): Boolean = {
    node.exists(n =>
      word(position) match {
        case p if toLowerCase(p) < toLowerCase(n.data) => exists(n.left, word, position)
        case p if toLowerCase(p) > toLowerCase(n.data) => exists(n.right, word, position)
        case _ =>
          if (n.isEnd && position + 1 == word.length) true
          else if (position + 1 == word.length) false
          else exists(n.middle, word, position + 1)
      })
  }

  /**
    * recursive
    * @param node
    * @param word
    * @return
    */
  private def autoComplete(node: Option[Node], word: String): List[String] = {
    var results: List[String] = List()

    /**
      * traverse the tree, get all words in the node
      * @param node
      * @param word
      */
    def traverse(node: Option[Node], word: String): Unit =
      node.foreach { n =>
        val stringBuilder = new StringBuilder(word)
        //traverse left children
        traverse(n.left, stringBuilder.toString())
        stringBuilder.append(n.data)
        if (n.isEnd && results.length < MAX_SUGGESTIONS)
          results = results :+ stringBuilder.toString()
        //traverse middle children
        traverse(n.middle, stringBuilder.toString())
        //traverse right children
        var str = stringBuilder.toString()
        str = str.substring(0, str.length - 1)
        traverse(n.right, str)
      }

    /**
      * traverse tree corresponding to the prefix, get the node and then get all words of this node
      * @param node
      * @param prefix
      * @param position
      */
    def traverseWithPrefix(node: Option[Node], prefix: String, position: Int): Unit =
      node.foreach { n =>
        prefix charAt position match {
          case p if toLowerCase(p) > toLowerCase(n.data) => traverseWithPrefix(n.right, prefix, position)
          case p if toLowerCase(p) < toLowerCase(n.data) => traverseWithPrefix(n.left, prefix, position)
          case _ => //middle ok!
            if (position + 1 < prefix.length)
              traverseWithPrefix(n.middle, prefix, position + 1)
            else {
              if (n.isEnd && results.length < MAX_SUGGESTIONS)
                results = results :+ prefix.toLowerCase
              traverse(n.middle, prefix.toLowerCase)
            }
        }
      }

    if (word.length == 0)
      traverse(node, "")
    else
      traverseWithPrefix(node, word, 0)
    results
  }

  /**
    * change char to lower cas
    * @param c
    * @return
    */
  private def toLowerCase(c: Char): Char = Character.toLowerCase(c)

}
