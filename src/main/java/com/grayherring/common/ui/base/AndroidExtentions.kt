package com.grayherring.common.ui.base

import android.net.Uri
import android.view.View
import android.view.ViewManager
import android.widget.ImageView
import com.grayherring.common.util.applyThrottle
import com.jakewharton.rxbinding.view.clicks
import com.squareup.picasso.Picasso
import io.palaima.debugdrawer.view.DebugView
import org.jetbrains.anko.custom.ankoView
import java.io.File

/**
* Created by davidmedina on 2/10/17 =).
*/

inline fun ViewManager.debugView(theme: Int = 0, init: (DebugView) -> Unit) = ankoView(::DebugView,
                                                                                        theme,
                                                                                        init)

fun View.throttleClick() = clicks().applyThrottle()

fun ImageView.loudImage(string: String) =
    Picasso.with(context).load(string).fit().centerInside().into(this)

fun ImageView.loudImage(id: Int) = Picasso.with(context).load(id).fit().centerInside().into(this)

fun ImageView.loudImage(uri: Uri) = Picasso.with(context).load(uri).fit().centerInside().into(this)

fun ImageView.loudImage(file: File) =
    Picasso.with(context).load(file).fit().centerInside().into(this)