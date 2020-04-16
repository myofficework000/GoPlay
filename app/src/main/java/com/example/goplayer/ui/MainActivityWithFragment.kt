package com.example.goplayer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.goplayer.R
import com.master.exoplayer.MasterExoPlayerHelper
import kotlinx.android.synthetic.main.activity_with_fragment.*

/**
 * Created by abhishek.pathak on 16/04/2020.
 */
class MainActivityWithFragment : AppCompatActivity() {

    lateinit var masterExoPlayerHelper: MasterExoPlayerHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_fragment)

        val videoPlayFragment = VidePlayFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, videoPlayFragment)
            .commit()

        btnSecond.setOnClickListener {
            supportFragmentManager.beginTransaction().add(
                R.id.container,
                SecondFragment()
            )
                .addToBackStack("SecondFragment")
                .commit()
        }
    }
}
