package com.example.practice_one.splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.practice_one.R
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)
        // 状态栏文字黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }
}