package com.example.practice_one.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    /*
    * 找控件
    * */
    protected open fun initViews() {}
    /*
    * 设置数据
    * */
    protected open fun initDatum() {}
    /*
    * 设置监听器
    * */
    protected open fun initListeners() {}
    /**
    * 在onCreate方法后调用
    * @param savedInstanceState
    * */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
        initDatum()
        initListeners()
    }
}