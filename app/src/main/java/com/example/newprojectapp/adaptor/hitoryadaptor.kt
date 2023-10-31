package com.example.newprojectapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newprojectapp.databinding.HistoryitemBinding
import com.example.newprojectapp.modle.HistoryModelClass

class hitoryadaptor(var ListHistory:ArrayList<HistoryModelClass>): RecyclerView.Adapter<hitoryadaptor.HistoryCoinViewHolder>() {
    class HistoryCoinViewHolder(var binding:HistoryitemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCoinViewHolder {
        return  HistoryCoinViewHolder(HistoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = ListHistory.size


    override fun onBindViewHolder(holder: HistoryCoinViewHolder, position: Int) {
        holder.binding.Time.text=ListHistory[position].timeAndDate
        holder.binding.Coin.text=ListHistory[position].coin
    }
}