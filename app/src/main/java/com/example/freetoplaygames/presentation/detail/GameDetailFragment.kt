package com.example.freetoplaygames.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private val viewModel2: GameViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //gameId = arguments.getInt()
        Log.d("keyyy", args.gameId.toString())

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

        initView()
        bindViewModel()

    }


    private fun bindViewModel(){

        viewModel.gameDetailUiState.observe(viewLifecycleOwner){

            when(it){
                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_SHORT).show()
                }
                is DetailUiState.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()

                }
                is DetailUiState.Success -> {
                    Toast.makeText(requireContext(), "Success oluyo", Toast.LENGTH_SHORT).show()
                    loadData(it.data)


                }
            }
        }



    }

    private fun initView(){
        val id = args.gameId.toString()
        bindViewModel()
        viewModel.getGameById(id)

    }



     fun loadData(gameDetailUiData: GameDetailUiData){
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