package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemImageBinding

class PixaAdapter (var list: List<ImageModel>): RecyclerView.Adapter<PixaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return  PixaViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
            holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
            return list.size
    }
    }
class PixaViewHolder(var binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(model: ImageModel) {

        binding.pixaImage.load(model.largeImageURL)

    }

}