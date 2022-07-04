package com.example.interviewpreparation.presentation.PullRequest

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interviewpreparation.databinding.FragmentClosedMrSingleItemBinding
import com.example.interviewpreparation.domain.model.ClosedMr


class ClosedMrViewHolder(private val binding: FragmentClosedMrSingleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: ClosedMr) {
        binding.tvTitle.text = data.title
        binding.tvClosedDate.text = data.closedDate
        binding.tvDateCreated.text = data.createdDate
        binding.tvUsername.text = data.userData.userName
        setImage(data.userData.userImage)
    }

    private fun setImage(userImage: String?) {
        Glide.with(binding.root.context)
            .asBitmap()
            .load(userImage)
            .into(binding.ivUserImage);
    }
}