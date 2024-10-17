package com.example.practice_one.compoent.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.FragmentManager
import com.example.practice_one.R
import com.example.practice_one.fragment.BaseDialogFragment
import com.example.superui.utils.ScreenUtil

// 视频链接教学
// https://www.bilibili.com/video/BV12z4y1B7bq?spm_id_from=333.788.player.switch&vd_source=8712472fa5076e5c912395d4bd966fb0&p=18
class TermServiceDialogFragment : BaseDialogFragment() {
    override fun initViews() {
        super.initViews()
        // 点击弹窗外边不能关闭
        isCancelable = false
    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ((ScreenUtil.getScreenWith(requireContext()) * 0.9).toInt())
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_term_service, container, false)
    }

    companion object {
        /*
        * 显示对话框
        * */
        fun show(supportFragmentManager: FragmentManager) {
            val dialogFragment = TermServiceDialogFragment()
            dialogFragment.show(supportFragmentManager, "TermServiceDialogFragment")
        }
    }
}