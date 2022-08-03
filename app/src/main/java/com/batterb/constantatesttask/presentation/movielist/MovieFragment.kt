package com.batterb.constantatesttask.presentation.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.batterb.constantatesttask.app.ConstantaTestTask
import com.batterb.constantatesttask.databinding.FragmentMovieBinding
import javax.inject.Inject

class MovieFragment : Fragment() {

    private lateinit var viewModel : MovieViewModel

    private lateinit var _binding: FragmentMovieBinding

    @Inject
    lateinit var movieViewModelFactory : MovieViewModelFactory

    @Inject
    lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity?.applicationContext as ConstantaTestTask).appComponent.inject(this)
        viewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        _binding = FragmentMovieBinding.inflate(inflater, container, false)

        val layoutManager = LinearLayoutManager(context)
        _binding.recyclerView.layoutManager = layoutManager
        _binding.recyclerView.adapter = adapter

        setObserver()
        viewModel.loadMovies()

        return _binding.root
    }

    private fun setObserver(){
        viewModel.movieList.observe(viewLifecycleOwner){
            if(it!=null) {
                adapter.movies = it.toMutableList()
            }
        }
    }

}