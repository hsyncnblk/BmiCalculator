package com.hsyncnblk.bmicalculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hsyncnblk.bmicalculator.R
import com.hsyncnblk.bmicalculator.databinding.FragmentMainBinding
import kotlin.math.pow


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainBinding.inflate(layoutInflater)
        return binding.root

        binding.calculateBtn.setOnClickListener {
            calculate()
        }

    }

    private fun calculate(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if (weight !=null && height !=null){

            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f",bmi)

            val bmiCategory=when{
                bmi<18.5 -> "Underweight"
                bmi<25 -> "Normal weight"
                bmi<30 -> "Overweight"
                else -> "Obese"
            }

            binding.resultText.text="BMI: $bmiResult \nCatagory: $bmiCategory"



        }else{
            binding.resultText.text="Invalid input"
        }


    }



}