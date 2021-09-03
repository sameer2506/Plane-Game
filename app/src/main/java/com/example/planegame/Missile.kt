package com.example.planegame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class Missile(context: Context) {
    var x: Int
    var y: Int
    var mVelocity: Int
    var missile: Bitmap
    val missileWidth: Int
        get() = missile.width
    val missileHeight: Int
        get() = missile.height

    init {
        missile = BitmapFactory.decodeResource(context.resources, R.drawable.missile)
        x = GameView.dWidth / 2 - missileWidth / 2
        y = GameView.dHeight - GameView.tankHeight - missileHeight / 2
        mVelocity = 50
    }
}
