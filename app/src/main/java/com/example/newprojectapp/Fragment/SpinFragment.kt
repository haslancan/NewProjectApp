package com.example.newprojectapp.Fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newprojectapp.Withdrawal
import com.example.newprojectapp.databinding.FragmentSpinBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.random.Random

class SpinFragment : Fragment() {
    private lateinit var binding: FragmentSpinBinding
    private lateinit var timer: CountDownTimer
    private val itemTitles = arrayOf("100", "Try Again", "500", "Try Again", "200", "Try Again")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::timer.isInitialized) {
            timer.cancel()
        }
    }

    private fun showResult(itemTitle: String) {
        Toast.makeText(requireContext(), itemTitle, Toast.LENGTH_SHORT).show()
        binding.Spin.isEnabled = true // Enable the button again
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SpinCoinWithDrawal.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.SpinCoinWithDrawal1.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }

        binding.Spin.setOnClickListener {
            binding.Spin.isEnabled = false // Disable the button while the wheel is spinning
            val spin = Random.nextInt(6) // Generate a random value between 0 and 5
            val degrees = 60f * spin // Calculate the rotation degrees based on the random value

            timer = object : CountDownTimer(5000, 50) {
                var rotation = 0f

                override fun onTick(millisUntilFinished: Long) {
                    rotation += 5f // Rotate the wheel
                    if (rotation >= degrees) {
                        rotation = degrees
                        timer.cancel()
                        showResult(itemTitles[spin])
                    }
                    binding.wheel.rotation = rotation
                }

                override fun onFinish() {}
            }.start()
        }
    }

}