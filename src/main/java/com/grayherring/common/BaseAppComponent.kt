package com.grayherring.common

import com.grayherring.common.dagger.PerApp
import dagger.Component

@PerApp
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface BaseAppComponent {

  fun inject(app: BaseApp)

  class Initializer internal constructor() {
    init {
      throw AssertionError("No instances.")
    }

    companion object {
      fun init(app: BaseApp): BaseAppComponent {
        return DaggerBaseAppComponent.builder()
            .appModule(AppModule(app))
            .dataModule(DataModule())
            .build()
      }
    }
  }


}

