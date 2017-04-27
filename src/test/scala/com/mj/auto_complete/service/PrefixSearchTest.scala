package com.mj.auto_complete.service

import com.mj.auto_complete.BaseTest
import com.mj.auto_complete.model.Node

/**
  * Created by fjim on 25/04/2017.
  */
class PrefixSearchTest extends BaseTest {
  private var tst: PrefixService = _
  before {
    tst = new PrefixService
  }

  /*"insert" should {
    "success when node is none" in {
      val node = tst.insert(None, "abc".toList, 0)
      assertResult('b')(node.middle.get.data)
      assertResult(true)(node.middle.get.middle.get.isEnd)
    }
    "success when node exists" in {
      val node = PrefixNode('a', middle = Some(PrefixNode('b', isEnd = true)))
      val res = tst.insert(Some(node), "adc".toList, 0)
      assertResult('d')(res.middle.get.right.get.data)
      assertResult(true)(res.middle.get.right.get.middle.get.isEnd)
      val res2 = tst.insert(Some(res), "aecb".toList, 0)
      println(res)
      val search = tst.search(Some(res), "aecb".toList, 0)
      println(search)
    }
  }

  "search" should {
    "success" in {
      val node = PrefixNode('a', middle = Some(PrefixNode('b', isEnd = true)))
      val insertRes = tst.insert(Some(node), "adc".toList, 0)
      tst.insert(Some(insertRes), "aecbd".toList, 0)
      assertResult(true)(tst.search(Some(insertRes), "aecbd".toList, 0))
      assertResult(true)(tst.search(Some(insertRes), "adc".toList, 0))
      assertResult(false)(tst.search(Some(insertRes), "aecbdd".toList, 0))
      assertResult(false)(tst.search(Some(insertRes), "adecbd".toList, 0))
    }
  }

  "auto complete" should {
    "success" in {
      val node = PrefixNode('a', middle = Some(PrefixNode('b', isEnd = true)))
      tst.insert(Some(node), "adc".toList, 0)
      tst.insert(Some(node), "daa".toList, 0)
      tst.insert(Some(node), "adca".toList, 0)
      assertResult(List("ab", "adc", "adca","daa"))(tst.autocomplete(Some(node), ""))
      assertResult(List("ab", "adc", "adca"))(tst.autocomplete(Some(node), "a"))
      assertResult(List("ab"))(tst.autocomplete(Some(node), "ab"))
      assertResult(List("adc","adca"))(tst.autocomplete(Some(node), "ad"))
      assertResult(List())(tst.autocomplete(Some(node), "e"))
    }
  }*/
}
