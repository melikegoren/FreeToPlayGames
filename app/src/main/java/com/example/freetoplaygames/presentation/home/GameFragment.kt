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
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()

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










    override fun onCardViewClick(gameHomeUiData: GameHomeUiData) {
        val navigate = findNavController()
        navigate.navigate(R.id.action_gamesFragment_to_gameDetailFragment)

    }




    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 1
        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L
    }

}
interface OnHomeClickListener{
    fun onCardViewClick(gameHomeUiData: GameHomeUiData)
}

