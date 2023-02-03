package com.example.freetoplaygames.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.text.toUpperCase
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.freetoplaygames.R
import com.example.freetoplaygames.databinding.FragmentGameDetailBinding
import com.example.freetoplaygames.presentation.home.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameDetailFragment : Fragment() {

   private var _binding: FragmentGameDetailBinding? = null
    val binding: FragmentGameDetailBinding get() = _binding!!



    private val args: GameDetailFragmentArgs by navArgs()

    private val viewModel: GameDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {


        _binding = FragmentGameDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getGameInfo()

    }


    private fun bindViewModel(){

        viewModel.gameDetailUiState.observe(viewLifecycleOwner){

            when(it){
                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_SHORT).show()

                }
                is DetailUiState.Loading -> {
                    whenLoading()


                }
                is DetailUiState.Success -> {
                    uploadData(it.data)


                }
            }
        }



    }

    private fun getGameInfo(){
        val id = args.gameId.toString()
        bindViewModel()
        viewModel.getGameById(id)

    }



     private fun uploadData(gameDetailUiData: GameDetailUiData){
        binding.apply {
            title.text = gameDetailUiData.title.uppercase()
            shortDescription.text = gameDetailUiData.shortDescription
            genre.text = "Genre: "+gameDetailUiData.genre
            platform.text = "Platform: "+gameDetailUiData.platform
            developer.text = "Developer: "+gameDetailUiData.developer
            publisher.text = "Publisher: "+gameDetailUiData.publisher
            Glide.with(this.image).load(gameDetailUiData.thumbnail).into(this.image)

        }

    }

    fun whenLoading(){
        binding.apply {
            title.text = null
            shortDescription.text = null
            genre.text = null
            platform.text = null
            developer.text = null
            publisher.text = null
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}