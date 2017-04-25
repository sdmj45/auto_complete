package com.mj.auto_complete


import com.mj.auto_complete.router.AutoCompleteRouter
import io.vertx.core.Future
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.ext.web.Router
import io.vertx.scala.ext.web.handler.BodyHandler

/**
  * Created by M on 24/04/2017.
  */
class MainVerticle extends ScalaVerticle {

  override def start(): Unit = {
    println("starting...")
    val router = Router.router(vertx)
    router.route().handler(BodyHandler.create())

//    router.get("/auto/:prefix").handler(AutoCompleteRouter.handleAutoComplete(_))
//    router.post("/auto/:prefix").handler(AutoCompleteRouter.save(_))

    vertx.createHttpServer()
      .requestHandler(router.accept(_))
      .listen(8080)
  }
}
