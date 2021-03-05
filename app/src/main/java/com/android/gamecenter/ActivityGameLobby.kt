gpackage com.android.gamecenter

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.android.gamecenter.databinding.ActivityLobbyBinding
import com.android.gamecenter.tictactoe.ActivityTicTacToe
import com.android.gamecenter.tictactoe.Board

class ActivityGameLobby : AppCompatActivity() {
    private lateinit var binding: ActivityLobbyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityLobbyBinding.inflate(layoutInflater)
        binding.playSnakeButton.setOnClickListener{
            soonDialogShow()
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