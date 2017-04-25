package com.mj.auto_complete.router

import com.mj.auto_complete.exception.HttpException
import io.vertx.core.http.impl.MimeMapping
import io.vertx.core.json.JsonObject
import io.vertx.core.logging.LoggerFactory
import io.vertx.scala.ext.web.RoutingContext

/**
  * Created by fjim on 25/04/2017.
  */
object CommonRouter {
  val CONTENT_TYPE: String = "content-type"
  val MIME_MAPPING: String = "json"
  val LOGGER = LoggerFactory.getLogger(classOf[CommonRouter])
}

class CommonRouter {

  import CommonRouter._

  def setDefaultContentType(routingContext: RoutingContext): Unit = {
    routingContext.response()
      .setChunked(true)
      .putHeader(CONTENT_TYPE, MimeMapping.getMimeTypeForExtension(MIME_MAPPING))
    routingContext.next()
  }

  def failureRouteHandler(routingContext: RoutingContext): Unit = {
    val failure = routingContext.failure()
    val statusCode = failure match {
      case e: HttpException => e.httpCode
      case _ => routingContext.statusCode()
    }
    val message = new JsonObject()
      .put("class", failure.getClass.getName)
      .put("message", failure.getMessage)

    routingContext.response()
      .setChunked(true)
      .setStatusCode(statusCode)
      .putHeader(CONTENT_TYPE, MimeMapping.getMimeTypeForExtension(MIME_MAPPING))
      .write(message.encode)
      .end()
  }
}
