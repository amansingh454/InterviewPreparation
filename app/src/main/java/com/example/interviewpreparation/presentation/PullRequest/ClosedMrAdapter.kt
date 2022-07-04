package com.example.interviewpreparation.presentation.PullRequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewpreparation.R
import com.example.interviewpreparation.domain.model.ClosedMr

class ClosedMrAdapter(private val data: List<ClosedMr>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosedMrViewHolder {
        return ClosedMrViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.fragment_closed_mr_single_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ClosedMrViewHolder).bind(data = data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}