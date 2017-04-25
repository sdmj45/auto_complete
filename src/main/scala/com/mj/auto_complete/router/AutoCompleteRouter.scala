package com.mj.auto_complete.router

import com.mj.auto_complete.app.AutoComplete
import io.vertx.scala.ext.web.RoutingContext

/**
  * Created by fjim on 25/04/2017.
  */
object AutoCompleteRouter{
  def apply(autoComplete: AutoComplete): AutoCompleteRouter = new AutoCompleteRouter(autoComplete)
}
class AutoCompleteRouter(autoComplete: AutoComplete) {

  def save(routingContext: RoutingContext): Unit = {
    val body = routingContext.getBodyAsJsonArray()
    autoComplete.insert(List("abc", "bcd", "abcd", "bced"))
    routingContext.response().end()
  }
  def auto_complete(routingContext: RoutingContext): Unit = {
    val prefix = routingContext.request().getParam("prefix")
    val res = autoComplete.autocomplete(prefix.getOrElse(""))
    routingContext.response()
      .setChunked(true)
      .write(res.toString())
      .end()
  }


  def handleAutoComplete(routingContext: RoutingContext): Unit = {
    val prefix = routingContext.request().getParam("prefix")
    routingContext.response()
      .setChunked(true)
      .putHeader("content-type", "application/json")
      .write(prefix.getOrElse(""))
      .end()
  }
}
