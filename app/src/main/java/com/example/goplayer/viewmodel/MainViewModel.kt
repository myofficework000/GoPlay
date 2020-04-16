/*
 * Copyright (c) 2020 Lutron. All rights reserved.
 */
package com.example.goplayer.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.goplayer.data.Model
import com.example.goplayer.repo.GoPlayRepo


/**
 * Created by abhishek.pathak on 08/04/2020.
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val videoRepo : GoPlayRepo = GoPlayRepo()
    val context: Context = application.applicationContext

    fun getVideoSource(language: String?, category: String?, country: String?): List<Model> {
        return videoRepo.getSampleData()
    }
}