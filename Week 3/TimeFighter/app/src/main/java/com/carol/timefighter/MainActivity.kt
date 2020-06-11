package com.carol.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    internal lateinit var tapButton: Button
    private lateinit var scoreText: TextView
    internal lateinit var timeleftText: TextView
    internal var scoreCount = 0
    internal var gameStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 20000
    internal val countDownInterval: Long = 1000
    internal val TAG = MainActivity::class.java.simpleName
    internal var timeleftOnTimer: Long = 60000

    companion object {
        private val SCORE_KEY = "SCORE_KEY"
        private val TIME_LEFT_KEY = "TIME_LEFT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called. Score is: $scoreCount")
        tapButton = findViewById<Button>(R.id.tap_button)
        scoreText = findViewById<TextView>(R.id.score_text_view)
        timeleftText = findViewById<TextView>(R.id.timeleft_text_view)
        if (savedInstanceState != null) {
            scoreCount = savedInstanceState.getInt(SCORE_KEY)
            timeleftOnTimer = savedInstanceState.getLong(TIME_LEFT_KEY)
            restoreGame()
        } else {
            resetGame()
        }
        tapButton.setOnClickListener { view ->
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)
            incrementScore()
        }
    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.game_over, scoreCount.toString()), Toast.LENGTH_LONG).show()
        resetGame()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, scoreCount)
        outState.putLong(TIME_LEFT_KEY, timeleftOnTimer)
        countDownTimer.cancel()
        Log.d(TAG, "onSaveInstanceSave: Saving Score: $scoreCount & Time Left: $timeleftOnTimer")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called.")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_about) {
            showInfo()
        }
        return true
    }

    private fun showInfo() {
        val dialogTitle = getString(R.string.about_title)
        val dialogMessage = getString(R.string.about_message)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }

    private fun restoreGame() {
        scoreText.text = getString(R.string.score, scoreCount.toString())
        val restoredTime = timeleftOnTimer / 1000
        timeleftText.text = getString(R.string.timeleft, restoredTime.toString())
        countDownTimer = object : CountDownTimer(timeleftOnTimer, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeleftOnTimer = millisUntilFinished
                var timeleft = millisUntilFinished / 1000
                timeleftText.text = getString(R.string.timeleft, timeleft.toString())
            }
            override fun onFinish() {
                endGame()
            }
        }
        countDownTimer.start()
        gameStarted = true
    }

    private fun resetGame() {
        scoreCount = 0
        scoreText.text = getString(R.string.score, scoreCount.toString())
        val initialTimeLeft = initialCountDown / 1000
        timeleftText.text = getString(R.string.timeleft, initialTimeLeft.toString())
        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeleftOnTimer = millisUntilFinished
                val timeleft = millisUntilFinished / 1000
                timeleftText.text = getString(R.string.timeleft, timeleft.toString())
            }
            override fun onFinish() {
                endGame()
            }
        }
        gameStarted = false
    }

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        scoreCount += 1
        val newScore = getString(R.string.score, scoreCount.toString())
        scoreText.text = newScore
        val blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink)
        scoreText.startAnimation(blinkAnimation)
    }
}

