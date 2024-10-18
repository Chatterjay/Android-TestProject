package com.example.practice_one.compoent.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.core.text.HtmlCompat
import androidx.fragment.app.FragmentManager
import com.example.practice_one.R
import com.example.practice_one.fragment.BaseCommonFragment
import com.example.superui.process.SuperProcessUtils
import com.example.superui.utils.ScreenUtil
import com.example.superui.utils.SuperTextUtils

class TermServiceDialogFragment : BaseCommonFragment() {
    private lateinit var onAgreementClickListener: View.OnClickListener
    private lateinit var contextView: TextView
    private lateinit var primaryView: TextView
    private lateinit var disagreeView: TextView

    override fun initViews() {
        super.initViews()
        // 点击弹窗外边不能关闭
        isCancelable = false
        contextView = findViewById(R.id.content)
        SuperTextUtils.setLinkColor(contextView, getColor(requireContext(), R.color.link))

        primaryView = findViewById<TextView>(R.id.primary)
        disagreeView = findViewById<TextView>(R.id.disagree)
    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ((ScreenUtil.getScreenWith(requireContext()) * 0.9).toInt())
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun initDatum() {
        super.initDatum()
        // 兼容旧版写法
        // val content = Html.fromHtml(getString(R.string.term_service_privacy_content))
        val content =
            HtmlCompat.fromHtml(getString(R.string.term_service_privacy_content), HtmlCompat.FROM_HTML_MODE_LEGACY)
        contextView.text = content
    }

    override fun initListeners() {
        super.initListeners()
        // 同意按钮
        primaryView.setOnClickListener {
            dismiss()
            onAgreementClickListener.onClick(it)
        }
        disagreeView.setOnClickListener{
            dismiss()
            SuperProcessUtils.killApp()
        }
    }

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_term_service, container, false)
    }

    companion object {
        /**
        * 显示对话框
        * */
        fun show(supportFragmentManager: FragmentManager, onAgreementClickListener: View.OnClickListener) {
            val dialogFragment = TermServiceDialogFragment()
            dialogFragment.onAgreementClickListener = onAgreementClickListener
            dialogFragment.show(supportFragmentManager, "TermServiceDialogFragment")
        }
    }
}