package com.abhishek.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by abhishek.pathak on 08/04/2020.
 */

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

