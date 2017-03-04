package com.grayherring.common

import android.app.Activity
import android.support.multidex.MultiDexApplication
import io.palaima.debugdrawer.timber.data.LumberYard
import timber.log.Timber


abstract class BaseApp : MultiDexApplication() {
  companion object {
    fun get(activity: Activity): BaseApp {
      return activity.application as BaseApp
    }
  }

  val component = initComponent()

  private fun initComponent(): BaseAppComponent {
    return BaseAppComponent.Initializer.init(this)
  }

  override fun onCreate() {
    super.onCreate()
     component.inject(this)

    val lumberYard = LumberYard.getInstance(this)
    lumberYard.cleanUp()
    Timber.plant(lumberYard.tree())
    Timber.plant(Timber.DebugTree())
  }

}

