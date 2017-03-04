package com.grayherring.common

import com.grayherring.common.dagger.PerApp
import com.grayherring.common.util.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: BaseApp) {

  @Provides @PerApp fun provideApplication(): BaseApp {
    return app
  }

  @Provides @PerApp fun provideErrorHandler(): ErrorHandler = ErrorHandler
}