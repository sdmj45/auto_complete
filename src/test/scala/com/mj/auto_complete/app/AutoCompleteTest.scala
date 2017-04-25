package com.mj.auto_complete.app

import com.mj.auto_complete.BaseTest
import com.mj.auto_complete.business.TernarySearchTree

/**
  * Created by fjim on 24/04/2017.
  */
class AutoCompleteTest extends BaseTest {
  private var app: AutoComplete = _

  before {
    app = AutoComplete(new TernarySearchTree)
  }

  "search" should {
    "success" in {
      app.insert(List("Abc", "bcd", "aBCd"))
      assertResult(true)(app.search("abc"))
      assertResult(true)(app.search("Bcd"))
      assertResult(true)(app.search("abcd"))
      assertResult(false)(app.search("abcde"))
    }
  }

  "autocomplete" should {
    "success" in {
      app.insert(List("abc", "bcd", "abcd", "bced"))
      println(app.autocomplete("ab"))
      assertResult(List("abc", "abcd"))(app.autocomplete("a"))
      assertResult(List("bcd", "bced"))(app.autocomplete("bc"))
    }
    "success2" in {
      app.insert(List("Pandora", "Pinterest", "Paypal", "Pg&e","Project free tv Priceline","Press democrat","Progressive","Project runway","Proactive","Programming","Progeria"
        ,"Progesterone","Progenex","Procurable","Processor","Proud","Print","Prank","Bowl","Owl","River","Phone","Kayak","Stamps","Reprobe"))
      println(app.autocomplete(""))
    }
  }
}
