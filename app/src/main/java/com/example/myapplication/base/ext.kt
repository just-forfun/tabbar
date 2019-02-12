package com.example.myapplication.base

import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity

inline fun <reified T> Fragment.argument(key: String): Lazy<T> = lazy {
    val value = this.arguments?.get(key)

    if (value is T) {
        value
    } else {
        throw IllegalArgumentException(
            "Couldn't find argument with key \"$key\" from type " +
                    T::class.java.canonicalName
        )
    }
}

fun MyFragment.pushFragment(fragment: MyFragment) {
    (activity as? MainActivity)?.pushFragment(fragment)
}