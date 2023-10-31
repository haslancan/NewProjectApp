package com.example.newprojectapp.adaptor

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newprojectapp.QuizActivity
import com.example.newprojectapp.databinding.CategoryitemBinding
import com.example.newprojectapp.modle.categoryModelClass

class categoryadaptor(
    var categoryList: ArrayList<categoryModelClass>, private var requireActivity: FragmentActivity
): RecyclerView.Adapter<categoryadaptor.MycategoryViewHolder>() {
    class MycategoryViewHolder(var binding: CategoryitemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MycategoryViewHolder {
        return  MycategoryViewHolder(CategoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: MycategoryViewHolder, position: Int) {
        var dataList = categoryList[position]
        holder.binding.categoryMage.setImageResource(dataList.catImage)
        holder.binding.category.text=dataList.catText

        holder.binding.categorybtn.setOnClickListener {


            var intent = Intent(requireActivity,QuizActivity::class.java)
            intent.putExtra("categoryimg",dataList.catImage)
            requireActivity.startActivity(intent)
        }
    }

}