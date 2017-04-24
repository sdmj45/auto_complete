package com.mj.auto_complete.business

import com.mj.auto_complete.model.Node
import org.scalatest.{BeforeAndAfter, Matchers, WordSpec}

/**
  * Created by fjim on 24/04/2017.
  */
class TernarySearchTreeTest extends WordSpec with Matchers with BeforeAndAfter {
  private var tst: TernarySearchTree = _
  before {
    tst = new TernarySearchTree
  }

  "insert" should {
    "success when node is none" in {
      val node = tst.insert(None, "abc".toList, 0)
      assertResult('b')(node.middle.get.data)
      assertResult(true)(node.middle.get.middle.get.isEnd)
    }
    "success when node exists" in {
      val node = Node('a', middle = Some(Node('b', isEnd = true)))
      val res = tst.insert(Some(node), "adc".toList, 0)
      println(res)
      assertResult('d')(res.middle.get.right.get.data)
      assertResult(true)(res.middle.get.right.get.middle.get.isEnd)
    }
  }
}
