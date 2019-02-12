package com.example.myapplication.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.base.GenericFragment
import com.example.myapplication.base.MyFragment
import com.example.myapplication.base.argument
import com.example.myapplication.data.model.User
import kotlinx.android.synthetic.main.user_fragment.view.*

class UserFragment : MyFragment() {
    private lateinit var itemview: View
    private val user by argument<User>(EXTRA_USER)

    companion object {
        private const val EXTRA_USER = "USER"

        fun newInstance(user: User): UserFragment {
            return UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_USER, user)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemview = view ?: inflater.inflate(R.layout.user_fragment, container, false)

        setupViews()
        return itemview
    }

    private fun setupViews() {
        activity?.let {
            val tabAdapter = TabAdapter(it.supportFragmentManager)
            tabAdapter.addFragment(GenericFragment.newInstance(user.name, true), "Nome")
            tabAdapter.addFragment(GenericFragment.newInstance(user.phoneNumber, true), "Tenefone")

            itemview.useVPtabs.adapter = tabAdapter
            itemview.useTblTabs.setupWithViewPager(itemview.useVPtabs)
        }
    }
}