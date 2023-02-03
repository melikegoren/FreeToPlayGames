package com.example.freetoplaygames.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.freetoplaygames.R
import com.example.freetoplaygames.databinding.FragmentGameDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailFragment : Fragment() {

   private var _binding: FragmentGameDetailBinding? = null
    val binding: FragmentGameDetailBinding get() = _binding!!

    private var gameId: Int? = null

    private val viewModel: GameDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //gameId = arguments.getInt()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGameDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }

    private fun bindViewModel(){

        viewModel.gameDetailUiState.observe(viewLifecycleOwner){
            when(it){
                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_SHORT).show()
                }
                is DetailUiState.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()

                }
                is DetailUiState.Success -> {

                }
            }
        }


    }

    private fun loadData(gameDetailUiData: GameDetailUiData){
        binding.apply {
            title.text = gameDetailUiData.title
            shortDescription.text = gameDetailUiData.shortDescription
            genre.text = gameDetailUiData.genre
            platform.text = gameDetailUiData.platform
            developer.text = gameDetailUiData.developer
            publisher.text = gameDetailUiData.publisher
            Glide.with(this.image).load(gameDetailUiData.thumbnail).into(this.image)

        }

    }



}