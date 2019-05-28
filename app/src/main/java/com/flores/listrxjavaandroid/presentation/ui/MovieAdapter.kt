package com.flores.listrxjavaandroid.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flores.listrxjavaandroid.R
import com.flores.listrxjavaandroid.domain.entity.Movie
import com.flores.listrxjavaandroid.util.ITEM_MOVIE

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()


    fun addMovies(movies: List<Movie>) {
        this.items.addAll(movies)
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {


        }
    }

}