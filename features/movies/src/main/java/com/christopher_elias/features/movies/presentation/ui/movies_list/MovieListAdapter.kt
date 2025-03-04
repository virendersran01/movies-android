package com.christopher_elias.features.movies.presentation.ui.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import com.christopher_elias.common.models.presentation.MovieUi
import com.christopher_elias.common.ui_components.MoviePosterViewHolder
import com.christopher_elias.common.ui_components.databinding.ItemMoviePosterBinding

/*
 * Created by Christopher Elias on 26/04/2021
 * christopher.mike.96@gmail.com
 *
 * Loop Ideas
 * Lima, Peru.
 */

class MovieListAdapter : ListAdapter<MovieUi, MoviePosterViewHolder>(MovieDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        val holder = MoviePosterViewHolder(
            ItemMoviePosterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        holder.binding.root.setOnClickListener {
            it.findNavController().navigate(
                MovieListFragmentDirections.actionGoToSheetDetail(
                    getItem(holder.adapterPosition)
                )
            )
        }
        return holder
    }

    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        holder.bind(getItem(position).image)
    }
}