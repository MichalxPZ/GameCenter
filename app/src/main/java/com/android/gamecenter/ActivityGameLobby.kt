package com.android.gamecenter

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.gamecenter.databinding.ActivityLobbyBinding
import com.android.gamecenter.snake.ActivitySnake
import com.android.gamecenter.tictactoe.ActivityTicTacToe
import com.android.gamecenter.tictactoe.Board

class ActivityGameLobby : AppCompatActivity() {
    private lateinit var binding: ActivityLobbyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val actionBar = supportActionBar
        actionBar?.hide()
        binding = ActivityLobbyBinding.inflate(layoutInflater)
        binding.playSnakeButton.setOnClickListener{
            val intent = Intent(this, ActivitySnake::class.java)
            startActivity(intent)
        }
        binding.playTetrisButton.setOnClickListener {
            soonDialogShow()
        }
        binding.playTicTacToeButton.setOnClickListener {
            val intent: Intent = Intent(this, ActivityTicTacToe::class.java)
            Board.fields = charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
            startActivity(intent)
        }
        setContentView(binding.root)
    }

    fun soonDialogShow() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Soon...")
        dialogBuilder.setPositiveButton("Done",
                DialogInterface.OnClickListener { dialog, whichButton -> })
        val b = dialogBuilder.create()
        b.show()
    }
}