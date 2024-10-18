package com.example.superui.utils

import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.widget.TextView

object SuperTextUtils {
    /*
    * 文本工具
    *
    * */
    fun setLinkColor(view: TextView, color: Int) {
        view.movementMethod = (LinkMovementMethod.getInstance())
        view.setLinkTextColor(color)
    }
}