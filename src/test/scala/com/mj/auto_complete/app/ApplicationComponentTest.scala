package com.mj.auto_complete.app

import com.mj.auto_complete.BaseTest
import com.mj.auto_complete.component.ComponentRegistry

/**
  * Created by fjim on 24/04/2017.
  */
class ApplicationComponentTest extends BaseTest {
  private val app = ComponentRegistry.app

  before {
    app.insert(List("Abc", "bcd", "aBCd"))
  }

  "exists" should {
    "return true when elements exist, return false when it does not exist(case no sensible)" in {
      assertResult(true)(app.search("abc"))
      assertResult(true)(app.search("Bcd"))
      assertResult(true)(app.search("abcd"))
      assertResult(false)(app.search("abcde"))
    }
  }

  "autocomplete" should {
    "success" in {
      assertResult(List("abc", "abcd"))(app.autoComplete("a"))
      assertResult(List("bcd"))(app.autoComplete("bc"))
    }
    "test with the given elements" in {
      app.clear()
        .insert(List("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria"
          , "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"))

      assertResult(List("pandora", "paypal", "pg&e", "phone"))(app.autoComplete("p"))
      assertResult(List("prank", "press democrat", "print", "proactive"))(app.autoComplete("pr"))
      assertResult(List("proactive", "processor", "procurable", "progenex"))(app.autoComplete("pro"))
      assertResult(List("progenex", "progeria", "progesterone", "programming"))(app.autoComplete("prog"))
    }
  }
}
