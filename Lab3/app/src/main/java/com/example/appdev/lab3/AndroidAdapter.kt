package com.example.appdev.lab3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.app.Activity
import android.graphics.Bitmap
import android.widget.TextView
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_layout.view.*
import org.w3c.dom.Text

class AndroidAdapter (private val context: Context, private val android: List<Android>): RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {




    private fun getContext():Context{
        return context
    }




    class MyImlInterface(private val context: Context, private val viewId:Int ): View.OnClickListener {


        override fun onClick(p0: View?) {
            val intent = Intent(this.context, PageActivity::class.java)

            // передаём данные в intent
            intent.putExtra("profileId", viewId)
            context.startActivity(intent)
        }
    }


    private val inflater: LayoutInflater = LayoutInflater.from(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mview = ViewHolder(inflater.inflate(R.layout.recycler_view_layout, parent, false))
        return mview
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener(MyImlInterface(getContext(), position))

    }

    override fun getItemCount(): Int = android.size

    private fun getItem(position: Int): Android = android[position]


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.name_in_page)

        fun bind(version: Android) {
            image.setImageResource(version.imageAndroid)
            image.setTag(version.imageAndroid)
            title.text = version.title

        }
    }

}






