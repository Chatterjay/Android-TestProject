package com.example.superui.date

import android.icu.util.Calendar

object SuperDateUtils {
    fun currentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}