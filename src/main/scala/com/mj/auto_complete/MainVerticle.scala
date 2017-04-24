package com.mj.auto_complete

import io.vertx.core.{AbstractVerticle, Future}

/**
  * Created by M on 24/04/2017.
  */
class MainVerticle extends AbstractVerticle {
  override def start(startFuture: Future[Void]): Unit = {
    println("starting...")
    vertx.createHttpServer()
      .requestHandler(request => request.response().end("hello"))
      .listen(8080)
  }
}
