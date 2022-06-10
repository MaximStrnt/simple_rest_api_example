package com.example.apiexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pexkot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyInterface {

    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<String>()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        myAdapter = MyAdapter(list, APP_ACTIVITY)
        binding.recyclerView.adapter = myAdapter

        binding.btnSearch.setOnClickListener(View.OnClickListener {
            val text = binding.textSearch.query.toString()
            if (text.isEmpty()) {
                Toast.makeText(
                    APP_ACTIVITY,
                    "Search line is empty!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                getPictures(myAdapter, text, list)
            }
            binding.loadingCircle.visibility = View.INVISIBLE
        })
    }
}