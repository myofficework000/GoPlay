package com.abhishek.newsapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.newsapp.adapter.viewholder.VideoSourceViewHolder
import com.abhishek.newsapp.inflate
import com.example.goplayer.R
import com.example.goplayer.data.Model

/**
 * Created by abhishek.pathak on 08/04/2020.
 */
class VideoSourceAdapter(
    private val listener: (Model) -> Unit,
    private var sourceList: List<Model>
) : RecyclerView.Adapter<VideoSourceViewHolder>() {


    override fun getItemCount(): Int {
        return sourceList.size
    }

    private fun getItem(position: Int): Model {
        return sourceList[position]
    }

    override fun onBindViewHolder(holder: VideoSourceViewHolder, position: Int) =
        holder.bind(getItem(position), listener)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoSourceViewHolder =
        VideoSourceViewHolder(parent.inflate(R.layout.item))

    fun updateDataSet(data: List<Model>) {
        sourceList = data
        notifyDataSetChanged()
    }
}