package com.example.practice_one.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/*
* 所有DialogFragment对话框的父类
* */
abstract class BaseDialogFragment : DialogFragment() {
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
     * 显示要返回的控件
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = getLayoutView(inflater, container, savedInstanceState)
        return view
    }

    open abstract fun getLayoutView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        bundle: Bundle?
    ): View?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initDatum()
        initListeners()
    }
}