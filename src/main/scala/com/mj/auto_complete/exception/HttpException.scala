package com.mj.auto_complete.exception

/**
  * Created by fjim on 25/04/2017.
  */
case class HttpException(httpCode: Int, message: String) extends Exception
