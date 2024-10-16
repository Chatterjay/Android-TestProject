package com.example.tiptime

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    //  绑定对象
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
//      初始化binding 用于访问activity_main.xml 布局中的UI元素(View视图)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//      设置 root 将内容视图设置为activity(活动)的布局根视图
        setContentView(binding.root)
//      在按钮上设置监听器-执行计算小费的方法calculateTip()
        binding.button.setOnClickListener { calculateTip() }
        displayTip(0.0)
    }

    private fun calculateTip() {
        val inputAmount = binding.editTextNumberDecimal.text.toString()
        // 转换类型
        val const = inputAmount.toDoubleOrNull()
        if (const == null) return displayTip(0.0)
        // 根据单选框选额小费的百分比
        var tipPercentage = when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.radioButton2 -> 0.21
            R.id.radioButton5 -> 0.16
            else -> 0.1
        }
        // 计算小费 向上取整
        var tip = round(const * tipPercentage)
        // 展示小费
        displayTip(tip)
    }

    // 展示小费的方法
    fun displayTip(tip: Double) {
        // 货币格式展示
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.textView3.text = getString(R.string.TipAmount, formattedTip)
    }
}
