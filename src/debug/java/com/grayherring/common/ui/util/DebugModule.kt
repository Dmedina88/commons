package com.grayherring.common.ui.util

import com.grayherring.common.dagger.PerActivity
import com.grayherring.common.ui.base.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class DebugModule(private val activity: BaseActivity)
{

  @Provides @PerActivity fun provideActivity(): BaseActivity {
    return activity
  }
}