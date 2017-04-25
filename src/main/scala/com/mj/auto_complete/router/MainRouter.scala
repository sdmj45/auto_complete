package com.mj.auto_complete.router

import io.vertx.core.http.HttpMethod
import io.vertx.core.http.impl.MimeMapping
import io.vertx.scala.ext.web.Router

/**
  * Created by fjim on 25/04/2017.
  */
object MainRouter {
}

class MainRouter(val router: Router)(implicit val commonRouter: CommonRouter) {

  import MainRouter._

  def get(path: String) = {
    router.route(path).method(HttpMethod.GET)
      .handler(commonRouter.failureRouteHandler(_))
      .failureHandler(commonRouter.setDefaultContentType(_))
  }
}
