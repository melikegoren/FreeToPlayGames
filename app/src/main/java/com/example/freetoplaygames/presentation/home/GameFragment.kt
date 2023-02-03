package com.example.freetoplaygames.presentation.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.freetoplaygames.R
import com.example.freetoplaygames.common.Resource
import androidx.navigation.ui.navigateUp
import com.example.freetoplaygames.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.freetoplaygames.presentation.home.GameFragment

import kotlinx.coroutines.flow.*


@AndroidEntryPoint
class GameFragment : Fragment(), OnHomeClickListener {

    private var _binding: FragmentGameBinding? = null
    val binding get() = _binding!!

    private lateinit var gameAdapter: GameAdapter

    private val viewModel by viewModels<GameViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        bindViewModel()
        searhView()




    }



    private fun bindViewModel(){
        viewModel.gamesUiState.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_SHORT).show()

                }
                HomeUiState.Loading -> {
                    whenLoading()

                }
                is HomeUiState.Success -> {
                    gameAdapter = GameAdapter(it.data as ArrayList<GameHomeUiData>, requireContext(),this)
                    binding.recyclerView.adapter = gameAdapter


                }
            }
        }
    }

    private fun searhView(){
        binding.searcView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                gameAdapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                gameAdapter.getFilter().filter(newText)
                return true
            }

        })
    }

    private fun whenLoading(){
        binding.apply {
            recyclerView.adapter = null
        }

    }



    override fun onCardViewClick(id: Int) {
        val action = GameFragmentDirections.actionGamesFragmentToGameDetailFragment()
        action.gameId = id
        findNavController().navigate(action)
    }


}
interface OnHomeClickListener{
    fun onCardViewClick(id: Int)
}

