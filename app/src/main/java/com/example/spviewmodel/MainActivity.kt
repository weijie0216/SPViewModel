package com.example.spviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare module-level variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        //Initialise the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Add an observer to the CountViewModel
        countViewModel.count.observe(this, Observer {
            if (it.equals(4))
                goodluck()
        })

        textViewCount.text = countViewModel.count.value.toString()

        buttonPlus.setOnClickListener {
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value.toString()
        }
    }

    private fun goodluck() {
        Toast.makeText(applicationContext, "Good luck", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
