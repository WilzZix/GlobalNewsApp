package com.example.newsapphomework.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.newsapphomework.R
import kotlinx.android.synthetic.main.fragment_category.view.*

class CategoryFragment : Fragment(R.layout.fragment_category) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.business_next_btn.setOnClickListener {
            findNavController().navigate(R.id.to_businessNewsFragment)
        }
        view.entertainment_next_btn.setOnClickListener {
            findNavController().navigate(R.id.to_entertainmentFragment)

        }
    }
}
