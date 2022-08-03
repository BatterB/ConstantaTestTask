package com.batterb.constantatesttask.presentation.movielist

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.batterb.constantatesttask.databinding.MovieItemBinding
import com.batterb.constantatesttask.domain.model.Movie

class MovieDiffCallback(
    private val oldList: List<Movie>,
    private val newList: List<Movie>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = oldList[oldItemPosition]
        val newMovie = newList[newItemPosition]
        return oldMovie.title == newMovie.title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = oldList[oldItemPosition]
        val newMovie = newList[newItemPosition]
        return oldMovie == newMovie
    }
}

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(), View.OnClickListener {

    class MovieViewHolder(
        val binding : MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var movies : MutableList<Movie> = mutableListOf()
        set (newValue){
            val diffCallback = MovieDiffCallback(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onClick(view: View) {
        val movie = view.tag as Movie
        val dialogFragment = AlertDialog.Builder(view.context)
        dialogFragment.setMessage("Фильм ${movie.title} был нажат")
            .setPositiveButton("OK"){ dialog, _ ->
                    dialog.dismiss()
                }
        dialogFragment.show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent,false)

        binding.root.setOnClickListener(this)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.binding){

            holder.itemView.tag = movie

            val actorString ="Актеры: " + movie.actors.joinToString(", ")
            val director = "Режиcсер: ${movie.directorName}"
            val titleWithYear = "${movie.title} (${movie.releaseYear})"

            title.text = titleWithYear
            directorName.text = director
            actors.text = actorString

        }
    }

    override fun getItemCount(): Int = movies.size

}