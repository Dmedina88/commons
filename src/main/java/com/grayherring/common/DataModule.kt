package com.grayherring.common

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.grayherring.common.dagger.PerApp
import com.grayherring.common.dagger.Qualifiers.MockPref
import com.grayherring.common.util.BoolPreferences
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import org.jetbrains.anko.defaultSharedPreferences
import timber.log.Timber

const val PREF_NAME = "XzyPref"

@Module
class DataModule {

  @Provides @PerApp fun providePicasso(app: Application): Picasso {
    return Picasso.Builder(app)
        .listener { _, uri, e -> Timber.e(e, "Failed to load image: %s", uri) }
        .build()
  }

  @Provides @PerApp fun provideSharedPreferences(app: Application): SharedPreferences
      = app.defaultSharedPreferences

  @Provides @PerApp @MockPref fun provideMockPref(pref: SharedPreferences): BoolPreferences
      = BoolPreferences(pref, "MockPref")

}
