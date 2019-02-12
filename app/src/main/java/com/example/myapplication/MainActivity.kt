package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.data.Repository
import com.example.myapplication.users.UsersFragment

class MainActivity : AppCompatActivity() {

    private val repository by lazy { Repository(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.getUsers {
            pushFragment(UsersFragment.newInstance(it))
        }
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFrlContainer, fragment)
            addToBackStack("HOME")
            commit()
        }
    }
}
