package com.meli.fragmentdeeplinkbasicproject


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.meli.fragmentdeeplinkbasicproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments : ArrayList<Fragment> = arrayListOf(
            BlueFragment(),
            PurpleFragment(),
            YellowFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        binding.viewpager.adapter = adapter

        val btn = binding.bottomBlue
        btn.setOnClickListener{
            val uri = Uri.parse("https://pokeapi.co/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        if(binding.viewpager.currentItem == 0){
            super.onBackPressed()
        }else{
            binding.viewpager.currentItem = binding.viewpager.currentItem -1
        }
    }

}