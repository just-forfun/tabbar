package com.example.myapplication.data

import android.app.Activity
import com.example.myapplication.data.model.User

class Repository(private val activity: Activity) {

    fun getUsers(onSuccess: (List<User>) -> Unit) {
        Thread(Runnable {
            val users = List(50) {
                val number = it.toString().padStart(2, '0')
                User(
                    "Usuario $number",
                    "$number$number-$number$number"
                )
            }

            activity.runOnUiThread {
                onSuccess(users)
            }
        }).start()
    }
}