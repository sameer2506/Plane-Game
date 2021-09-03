package com.example.planegame

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class GameOver : Activity() {
    var tvScore: TextView? = null
    var tvPersonalBest: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)
        val score = intent.extras!!.getInt("score")
        val pref = getSharedPreferences("MyPref", 0)
        var scoreSP = pref.getInt("scoreSP", 0)
        val editor = pref.edit()
        if (score > scoreSP) {
            scoreSP = score
            editor.putInt("scoreSP", scoreSP)
            editor.commit()
        }
        tvScore = findViewById<View>(R.id.tvScore) as TextView
        tvPersonalBest = findViewById<View>(R.id.tvPersonalBest) as TextView
        tvScore!!.text = "" + score
        tvPersonalBest!!.text = "" + scoreSP
    }

    fun restart(view: View?) {
        val intent = Intent(this@GameOver, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun exit(view: View?) {
        finish()
    }
}
