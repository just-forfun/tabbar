package com.example.myapplication.users

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.MyFragment
import com.example.myapplication.base.argument
import com.example.myapplication.base.pushFragment
import com.example.myapplication.data.model.User
import com.example.myapplication.user.UserFragment
import kotlinx.android.synthetic.main.users_fragment.view.*
import java.util.*

class UsersFragment : MyFragment() {

    private lateinit var itemview: View

    private val users by argument<List<User>>(EXTRA_USERS)
    private val usersAdapter by lazy {
        UsersAdapter().apply {
            onItemClick = ::onUserClick
        }
    }

    companion object {
        const val EXTRA_USERS = "USERS"

        fun newInstance(users: List<User>): UsersFragment {
            return UsersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(EXTRA_USERS, users as ArrayList<out Parcelable>)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemview = view ?: inflater.inflate(R.layout.users_fragment, container, false)

        usersAdapter.data = users
        itemview.ussRecUsers.layoutManager = LinearLayoutManager(itemview.context)
        itemview.ussRecUsers.adapter = usersAdapter

        return itemview
    }

    private fun onUserClick(user: User) {
        pushFragment(UserFragment.newInstance(user))
    }
}