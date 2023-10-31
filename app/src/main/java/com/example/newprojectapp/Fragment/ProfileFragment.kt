package com.example.newprojectapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newprojectapp.R
import com.example.newprojectapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    val binding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)

    }
    var isExpand = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.imageButton.setOnClickListener {
            if (isExpand) {
                binding.expadableconsraintlayout.visibility=View.VISIBLE
                binding.imageButton.setImageResource(com.google.android.material.R.drawable.material_ic_menu_arrow_up_black_24dp)

            } else {
                binding.expadableconsraintlayout.visibility=View.GONE
                binding.imageButton.setImageResource(R.drawable.downarrow)

        }
            isExpand =! isExpand


        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

    }
}