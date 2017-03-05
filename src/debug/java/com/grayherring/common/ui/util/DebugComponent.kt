package com.grayherring.common.ui.util

import com.grayherring.common.dagger.PerActivity
import dagger.Subcomponent
import io.palaima.debugdrawer.base.DebugModule

@PerActivity
@Subcomponent(modules = arrayOf(DebugModule::class))
interface DebugComponent {

  fun inject(debugActivity: DebugViewActivity)

}

