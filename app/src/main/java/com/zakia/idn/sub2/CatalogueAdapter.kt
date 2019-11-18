package com.zakia.idn.sub2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zakia.idn.sub2.Model.Model
import kotlinx.android.synthetic.main.item_catalogue.view.*

class CatalogueAdapter(
    private val listmovie: ArrayList<Model>,
    private val listener: (Model) -> Unit
) : RecyclerView.Adapter<CatalogueAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_catalogue, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listmovie.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listmovie[position], listener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Model, listener: (Model) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context).load(model.thumb).apply(
                    RequestOptions()
                        .override(
                            resources.getDimensionPixelSize(R.dimen.width_thumb_movie_list)
                            , resources.getDimensionPixelSize(R.dimen.height_thumb_movie_list)
                        )
                ).into(catalogue_poster)
                catalogue_name.text = model.title
                catalogue_description.text = model.description

                itemView.setOnClickListener { listener(model) }
            }
        }
    }


}

