package com.example.newprojectapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newprojectapp.Withdrawal
import com.example.newprojectapp.adaptor.hitoryadaptor
import com.example.newprojectapp.databinding.FragmentHistoryBinding
import com.example.newprojectapp.modle.HistoryModelClass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryFragment : Fragment() {
    val binding by lazy {
        FragmentHistoryBinding.inflate(layoutInflater)
    }
    private var ListHistory = ArrayList<HistoryModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ListHistory.add(HistoryModelClass("12:03","200"))
        ListHistory.add(HistoryModelClass("05:46","200"))
        ListHistory.add(HistoryModelClass("11:50","500"))
        ListHistory.add(HistoryModelClass("09:03","100"))


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.HistoryCoinWithDrawal.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.HistoryCoinWithDrawal1.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.HistoryRecylerView.layoutManager=LinearLayoutManager(requireContext())
        var adaptor = hitoryadaptor(ListHistory)
        binding.HistoryRecylerView.adapter= adaptor
        binding.HistoryRecylerView.setHasFixedSize(true)
        // Inflate the layout for this fragment
        return binding.root

    }
    companion object {

    }
}