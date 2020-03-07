package com.Mark.mostpopuler.vacation.vacationlists.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.Mark.mostpopuler.R
import com.example.mostpopularapp.ui.mplist.models.Datum
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.list_item.view.*


class MostPopulerListAdapter :
    ListAdapter<Datum, MostPopulerListAdapter.ListViewHolder>(PostWithUserDC()) {

    var interaction: Interaction? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ListViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false), interaction
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    fun swapData(data: List<Datum>) {
        submitList(data.toMutableList())
    }

    inner class ListViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val clicked = getItem(adapterPosition)
            interaction?.itemsClicked(clicked)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: Datum) = with(itemView) {

            days_tv_value.text = item.abstract.toString()
            when {
                (item.media!!.size > 0 && item.media!!.get(0).mediaMetadata!!.size > 0) ->
                    Picasso.get().load(item.media!!.get(0).mediaMetadata!!.get(0).url).into(
                        app_icon
                    )
            }

        }
    }

    private class PostWithUserDC : DiffUtil.ItemCallback<Datum>() {
        override fun areItemsTheSame(oldItem: Datum, newItem: Datum) = oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Datum, newItem: Datum) = oldItem == newItem
    }
}