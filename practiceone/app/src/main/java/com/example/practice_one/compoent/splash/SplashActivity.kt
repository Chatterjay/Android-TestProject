package com.example.practice_one.compoent.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.example.practice_one.R
import com.example.practice_one.activity.BaseLogicActivity
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.example.superui.date.SuperDateUtils

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseLogicActivity() {
    private lateinit var copyright: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
    }

    override fun initViews() {
        super.initViews()
        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)
        copyright = findViewById(R.id.copyright)
    }

    override fun initDatum() {
        super.initDatum()
        // 设置年份
        val currentYear = SuperDateUtils.currentYear()
        copyright.text = getString(R.string.copyright_information, "$currentYear")
        showTermsServiceAgreementDialog()
    }

    /**
     * 显示服务条款
     * */
    private fun showTermsServiceAgreementDialog() {
        TermServiceDialogFragment.show(supportFragmentManager) {
            Log.d(TGA, "primaryView OnClick")
        }
    }

    companion object {
        const val TGA = "SplashActivity"
    }
}