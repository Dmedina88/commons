package com.grayherring.common

import android.app.Activity
import android.app.Application
import io.palaima.debugdrawer.timber.data.LumberYard
import timber.log.Timber


/**
 * Created by David Medina.
 */

abstract class BaseApp : Application() {
  companion object{
    fun get(activity: Activity): BaseApp {
      return activity.application as BaseApp
    }
  }

  //val component = initComponent()

  override fun onCreate() {
    super.onCreate()
   // component.inject(this)

    val lumberYard = LumberYard.getInstance(this)
    lumberYard.cleanUp()
    Timber.plant(lumberYard.tree())
    Timber.plant(Timber.DebugTree())
  }




}

