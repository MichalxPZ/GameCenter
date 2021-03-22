package com.android.gamecenter.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.gamecenter.ActivityGameLobby
import com.android.gamecenter.R
import com.android.gamecenter.databinding.ActivityLobbyBinding
import com.android.gamecenter.databinding.ActivityTictactoeBinding
import java.nio.file.Files.move

class ActivityTicTacToe: AppCompatActivity() {
    private lateinit var binding: ActivityTictactoeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val actionBar = supportActionBar
        actionBar?.hide()
        binding = ActivityTictactoeBinding.inflate(layoutInflater)
        binding.buttonReturnTicTacToe.setOnClickListener {
            val intent = Intent(this, ActivityGameLobby::class.java)
            startActivity(intent)
        }
        val boardButton = listOf(binding.buttonField00, binding.buttonField01, binding.buttonField02,
                                binding.buttonField10, binding.buttonField11, binding.buttonField12,
                                binding.buttonField20, binding.buttonField21, binding.buttonField22)
        val board = Board

        fun setBoard(){
            boardButton.forEachIndexed() {index, button ->
                button.text = board.fields[index].toString()
            }
            println(board.fields)
        }

        fun setCurrentPlayer() {
            binding.textViewCurrentPlayer.text = board.setTurn().toString()
        }

        fun setGameStatus() {
            when(board.findResults()){
                "X wins" -> showDialogWinner("PLAYER X WINS")
                "O wins" -> showDialogWinner("PLAYER O WINS")
                "Draw" -> showDialogWinner("Draw")
                else -> Unit
            }
        }

        boardButton.forEachIndexed(){index, button ->
            button.setOnClickListener {
                if (board.fields[index] == ' ') {
                    board.fields[index] = board.setTurn()
                    setBoard()
                    setCurrentPlayer()
                    setGameStatus()
                }
            }
        }

        binding.buttonRestartTicTacToe.setOnClickListener {
            Board.fields = charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
            setBoard()
            setCurrentPlayer()
            setGameStatus()
        }

        setContentView(binding.root)
    }
    fun showDialogWinner(message: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage(message)
        dialogBuilder.setPositiveButton("Finish",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val b = dialogBuilder.create()
        b.show()
    }
}
