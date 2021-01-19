package com.example.appdev.lab7


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation

class CatAdapter : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    private val cats: MutableList<CatResponse> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cats.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position], position)
    }

    class CatViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.cat_image)

        fun bind(cat: CatResponse, position: Int) {
            image.load(cat.image) {
                crossfade(true)
                placeholder(R.mipmap.ic_launcher)
                transformations(CircleCropTransformation())
            }
        }
    }

    fun clearCharacters() {
        cats.clear()
        notifyDataSetChanged()
    }

    fun addCats(newCats: List<CatResponse>) {
        cats += newCats
        notifyDataSetChanged()
    }

}