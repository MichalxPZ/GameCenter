package com.android.gamecenter.snake

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.android.gamecenter.ActivityGameLobby
import com.android.gamecenter.databinding.ActivitySnakeBinding

class ActivitySnake: AppCompatActivity() {
    private lateinit var binding: ActivitySnakeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val actionBar = supportActionBar
        actionBar?.hide()
        binding = ActivitySnakeBinding.inflate(layoutInflater)
        binding.snakeRestartButton.setOnClickListener {
            val intent: Intent = Intent(this, ActivitySnake::class.java)
            startActivity(intent)
        }
        binding.snakeReturnButton.setOnClickListener {
            val intent = Intent(this, ActivityGameLobby::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}