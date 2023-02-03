package com.example.freetoplaygames.presentation.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.text.toLowerCase
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.freetoplaygames.databinding.GameListItemBinding
import java.util.*
import java.util.logging.Filter
import java.util.logging.LogRecord
import kotlin.collections.ArrayList

class GameAdapter (private val gameList: ArrayList<GameHomeUiData>, private val context: Context, private val onHomeClickListener: OnHomeClickListener): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    private val initialGameList = ArrayList<GameHomeUiData>().apply {
        gameList.let { addAll(it) }
    }



    class GameViewHolder (val binding: GameListItemBinding): RecyclerView.ViewHolder(binding.root){


    }

    private val gameFilter = object : android.widget.Filter(){
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val filteredList: ArrayList<GameHomeUiData> = ArrayList()
            if(p0.isNullOrEmpty()){
                initialGameList.let { filteredList.addAll(it) }
            }
            else{
                val query = p0.toString().trim().toLowerCase()
                initialGameList.forEach{
                    if(it.title.toLowerCase(Locale.ROOT).contains(query)){
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            if(p1?.values is kotlin.collections.ArrayList<*>){
                gameList.clear()
                gameList.addAll(p1.values as ArrayList<GameHomeUiData>)
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gameList[position]

        holder.binding.apply {

            title.text = game.title
            Glide.with(this.thumbnail).load(game.thumbnail).into(this.thumbnail)

            gamesCardView.setOnClickListener {
                Log.d("gameIdd", game.id.toString())
                game.id?.let { it1 -> onHomeClickListener.onCardViewClick(it1)

                }

            }


        }


    }

    override fun getItemCount(): Int = gameList.size

    fun getFilter(): android.widget.Filter{
        return gameFilter
    }

}






