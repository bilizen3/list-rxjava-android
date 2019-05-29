package com.flores.listrxjavaandroid.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flores.listrxjavaandroid.R
import com.flores.listrxjavaandroid.domain.entity.Movie
import com.flores.listrxjavaandroid.presentation.entity.Loading
import com.flores.listrxjavaandroid.util.ITEM_MOVIE
import com.flores.listrxjavaandroid.util.LOADING
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ViewType>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == ITEM_MOVIE) {
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
        } else {
            LoadingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false))
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                (holder).bind(items[position] as Movie)
            }
            is LoadingViewHolder -> {
                (holder).bind()
            }
        }
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()


    fun addMovies(movies: List<Movie>) {
        items.addAll(movies)
        notifyDataSetChanged()
    }

    fun addLoading() {
        items.add(Loading())
        notifyItemInserted(items.size-1)
    }

    fun existsLoading():Boolean{
        if(getItemViewType(items.size-1) == LOADING){
            return true
        }
        return false
    }

    fun removeLoading() {
        items.removeAt(items.size - 1)
        notifyItemRemoved(items.size)
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {
            itemView.apply {
                tvId.text = movie.getId().toString()
                tvTitle.text = movie.getTitle()
            }
        }
    }

}