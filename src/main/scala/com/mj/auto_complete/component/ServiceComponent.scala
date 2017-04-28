package com.mj.auto_complete.component

import com.mj.auto_complete.service.Service

/**
  * Created by fjim on 27/04/2017.
  *
  * wrap the service
  */
trait ServiceComponent {
  val service: Service
}
