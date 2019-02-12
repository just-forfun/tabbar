package com.example.myapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_generic.view.*

class GenericFragment : MyFragment() {

    private val text by argument<String>(EXTRA_TEXT)
    private val showAction by argument<Boolean>(EXTRA_SHOW_ACTION)

    companion object {
        private const val EXTRA_TEXT = "TEXT"
        private const val EXTRA_SHOW_ACTION = "SHOW_ACTION"

        fun newInstance(text: String, showAction: Boolean = false): GenericFragment {
            return GenericFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TEXT, text)
                    putBoolean(EXTRA_SHOW_ACTION, showAction)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_generic, container, false).apply {
            this.genTxtText.text = text
            this.genBtnAction.visibility = if (showAction) VISIBLE else GONE

            this.genBtnAction.setOnClickListener {
                pushFragment(GenericFragment.newInstance("Volte!"))
            }
        }
    }
}