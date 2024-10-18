package com.example.practice_one.fragment
import android.view.View

abstract class BaseCommonFragment : BaseDialogFragment() {
    fun <T : View?> findViewById(id: Int): T {
        return requireView().findViewById(id)
    }
}