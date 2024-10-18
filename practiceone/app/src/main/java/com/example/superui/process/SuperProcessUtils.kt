package com.example.superui.process

import android.os.Process

object SuperProcessUtils {

    fun killApp(){
        Process.killProcess(Process.myPid())
    }
}