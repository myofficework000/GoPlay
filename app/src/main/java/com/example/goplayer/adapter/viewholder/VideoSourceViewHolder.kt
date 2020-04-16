package com.abhishek.newsapp.adapter.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.goplayer.R
import com.example.goplayer.data.Model
import com.master.exoplayer.ExoPlayerHelper
import kotlinx.android.synthetic.main.item.view.frame
import kotlinx.android.synthetic.main.item.view.image
import kotlinx.android.synthetic.main.item.view.ivVolume
import kotlinx.android.synthetic.main.item.view.text

/**
 * Created by abhishek.pathak on 08/04/2020.
 */
class VideoSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: Model, listener: (Model) -> Unit) = with(itemView) {
        text.text = model.title
        frame.url = model.sources
        frame.imageView = image
        image.load(model.thumb)

        ivVolume.setOnClickListener {
            frame.isMute = !frame.isMute

            if (frame.isMute) {
                ivVolume.setImageResource(R.drawable.ic_volume_off)
            } else {
                ivVolume.setImageResource(R.drawable.ic_volume_on)
            }
        }

        frame.listener = object : ExoPlayerHelper.Listener {
            override fun onBuffering(isBuffering: Boolean) {
                super.onBuffering(isBuffering)
                Log.i("TAG", isBuffering.toString())
            }

            override fun onPlayerReady() {
                super.onPlayerReady()
                ivVolume.visibility = View.VISIBLE
                if (frame.isMute) {
                    ivVolume.setImageResource(R.drawable.ic_volume_off)
                } else {
                    ivVolume.setImageResource(R.drawable.ic_volume_on)
                }
            }

            override fun onStop() {
                super.onStop()
                ivVolume.visibility = View.GONE
            }
        }
        itemView.setOnClickListener { listener(model) }
    }
}