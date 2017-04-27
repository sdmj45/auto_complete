package com.mj.auto_complete.service

import com.mj.auto_complete.BaseTest

/**
  * Created by fjim on 25/04/2017.
  */
class PrefixServiceTest extends BaseTest {
  private var service: Service = new PrefixService

  before {
    service.insert("ab").insert("adc").insert("aecbd").insert("daa").insert("adca")
  }

  "search" should {
    "return true when elements exist in base" in {
      assertResult(true)(service.search("aecbd"))
      assertResult(true)(service.search("adc"))
    }
    "return false when elements do not exist in base" in {
      assertResult(false)(service.search("aecbdd"))
      assertResult(false)(service.search("adecbd"))
    }
  }

  "auto complete" should {
    "return all elements when there is nothing in search(4 by default)" in {
      assertResult(List("ab", "adc", "adca", "aecbd"))(service.autoComplete(""))
    }
    "return elements with the prefix" in {
      assertResult(List("ab", "adc", "adca", "aecbd"))(service.autoComplete("a"))
      assertResult(List("ab"))(service.autoComplete("ab"))
      assertResult(List("adc", "adca"))(service.autoComplete("ad"))
      assertResult(List())(service.autoComplete("e"))
    }
  }

  "clear" should{
    "clear all elements in base" in {
      service.clear()
      assertResult(List())(service.autoComplete(""))
    }
  }
}
