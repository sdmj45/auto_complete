package com.mj.auto_complete.model

/**
  * Created by fjim on 24/04/2017.
  */
trait Node {
  def hasChildren: Boolean

  def remove(): Unit
}
