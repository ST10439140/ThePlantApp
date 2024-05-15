package com.khethelo.plantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var plantImageView: ImageView
    private lateinit var waterTextView: TextView
    private lateinit var healthTextView: TextView
    private lateinit var sunTextView: TextView
    private lateinit var waterBtn: Button
    private lateinit var fertilizeBtn: Button
    private lateinit var sunBtn: Button

    private var health = 100
    private var water = 0
    private var sunlight = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plantImageView = findViewById(R.id.plantImageView)

        waterBtn = findViewById(R.id.waterBtn)
        fertilizeBtn = findViewById(R.id.fertilizeBtn)
        sunBtn = findViewById(R.id.sunBtn)

        waterTextView = findViewById(R.id.waterTextView)
        healthTextView = findViewById(R.id.healthTextView)
        sunTextView = findViewById(R.id.sunTextView)

//functioning the buttons
        waterBtn.setOnClickListener {
            plantImageView.setImageResource(R.drawable.water_plant)
            health -= 1
            if (health < 0) health = 0
            water++
            if (water > 10) water = 10
            waterTextView.text = "Happiness: $water"
            healthTextView.text = "Hunger: $health"
        }

        fertilizeBtn.setOnClickListener {
            plantImageView.setImageResource(R.drawable.fertilize_plant)
            sunlight -= 1
            if (sunlight < 0) sunlight = 0
            health++
            if (health > 10) health = 10
            healthTextView.text = "Hunger: $health"
            sunTextView.text = "Cleanliness: $sunlight"
        }

        sunBtn.setOnClickListener {
            plantImageView.setImageResource(R.drawable.sun_plant)
            water -= 1
            if (water < 0) water = 0
            sunlight++
            if (sunlight > 10) sunlight = 10
            waterTextView.text = "Happiness: $water"
            sunTextView.text = "Cleanliness: $sunlight"
        }
    }
}
