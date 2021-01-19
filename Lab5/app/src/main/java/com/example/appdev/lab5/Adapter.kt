package com.example.appdev.lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.appdev.lab5.entity.TransactionEntity


class Adapter(context: Context): RecyclerView.Adapter<Adapter.ViewHolder>(){
    private var transactions : List<TransactionEntity> = emptyList()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction : TransactionEntity = transactions.get(position)
        holder.bind(transactions.get(position))
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.transaction_item, parent, false))

    }

    fun setItems(items: List<TransactionEntity>){
        this.transactions = items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val cost: TextView = itemView.findViewById(R.id.transaction_sum)
        private val tag: TextView = itemView.findViewById(R.id.transaction_description)
        private val isReasonableImage: ImageView = itemView.findViewById(R.id.isReasonableImage)

        fun bind(transaction: TransactionEntity){
            cost.text = transaction.cost.toString()
            tag.text = transaction.tag
            isReasonableImage.setImageResource(
                if (transaction.isReasonable) R.drawable.thumbs_up else R.drawable.thumb_down
            )
        }
    }

    override fun getItemCount(): Int = this.transactions.size


}