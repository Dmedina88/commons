package com.grayherring.common.ui.util

import android.os.Bundle
import com.grayherring.common.BaseApp
import com.grayherring.common.ui.base.BaseActivity
import com.grayherring.common.ui.base.debugView
import com.readystatesoftware.chuck.Chuck
import io.palaima.debugdrawer.actions.ActionsModule
import io.palaima.debugdrawer.actions.ButtonAction
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule
import io.palaima.debugdrawer.timber.TimberModule
import io.palaima.debugdrawer.view.DebugView
import org.jetbrains.anko.scrollView


class DebugViewActivity : BaseActivity() {

  private lateinit var component: DebugComponent
  private lateinit var debugView: DebugView

  override fun initializeDependencyInjector() {
    component = BaseApp.get(this).component.plus(DebugModule(this))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    scrollView {
      debugView = debugView { }
    }

    val chuckBtn = ButtonAction(
        "ChuckInterceptor ",
        { startActivity(Chuck.getLaunchIntent(this)) }
    )

    debugView.modules(
        ActionsModule(
            chuckBtn),
        TimberModule(),
        BuildModule(this),
        DeviceModule(this),
        NetworkModule(this),
        SettingsModule(this)
    )
  }

  override protected fun onStart() {
    super.onStart()
    debugView.onStart()
  }

  override protected fun onResume() {
    super.onResume()
    debugView.onResume()
  }

  override protected fun onPause() {
    super.onPause()
    debugView.onPause()
  }

  override protected fun onStop() {
    super.onStop()
    debugView.onStop()
  }
}