package com.mj.auto_complete.component

import com.mj.auto_complete.app.ApplicationComponent
import com.mj.auto_complete.service.{PrefixService, Service}

/**
  * Created by fjim on 27/04/2017.
  */
object ComponentRegistry extends ApplicationComponent with ServiceComponent {
  override val service: Service = new PrefixService
  override val app: ComponentRegistry.Application = new Application
}
