package com.example.newprojectapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newprojectapp.R
import com.example.newprojectapp.Withdrawal
import com.example.newprojectapp.adaptor.categoryadaptor
import com.example.newprojectapp.databinding.FragmentHomeBinding
import com.example.newprojectapp.modle.categoryModelClass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class HomeFragment : Fragment() {
    private val binding:FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private var categoryList = ArrayList<categoryModelClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryList.add(categoryModelClass(R.drawable.scince,"Scince"))
        categoryList.add(categoryModelClass(R.drawable.englishs,"Engilish"))
        categoryList.add(categoryModelClass(R.drawable.englishs,"History"))
        categoryList.add(categoryModelClass(R.drawable.mathmetic,"Mathematic"))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.CoinWithdrawal.setOnClickListener {
            val bottomSheetDialog:BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.coinWithdrawal1.setOnClickListener {
            val bottomSheetDialog:BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.CategoryReylerView.layoutManager=GridLayoutManager(requireContext(),2)


        var adapter = categoryadaptor(categoryList,requireActivity())
        binding.CategoryReylerView.adapter = adapter
        binding.CategoryReylerView.setHasFixedSize(true)
    }

    companion object {
    }


}