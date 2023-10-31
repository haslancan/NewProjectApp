package com.example.newprojectapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newprojectapp.databinding.ActivityQuizBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class QuizActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var image = intent.getIntExtra("categoryimg",0)
        binding.categoryimg.setImageResource(image)

        binding.HistoryCoinWithDrawal1.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.HistoryCoinWithDrawal.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
    }

}
