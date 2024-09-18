package com.bedirhan.logoanim

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraFrame = findViewById<ImageView>(R.id.camera_frame)
        val broccoliImage = findViewById<ImageView>(R.id.broccoli_image)
        val aiImage = findViewById<ImageView>(R.id.ai_image)

        // Kamera Pozlaması Animasyonu
        val cameraZoomIn = AnimationUtils.loadAnimation(this, R.anim.camera_zoom_in)
        cameraFrame.visibility = View.VISIBLE
        cameraFrame.startAnimation(cameraZoomIn)

        // Kamera animasyonu tamamlandıktan sonra brokolinin belirmesi
        cameraZoomIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                val broccoliFadeIn = AnimationUtils.loadAnimation(this@MainActivity, R.anim.broccoli_fade_in)
                broccoliImage.visibility = View.VISIBLE
                broccoliImage.startAnimation(broccoliFadeIn)

                // Brokoli animasyonu tamamlandığında AI yazısı PNG olarak belirecek
                broccoliFadeIn.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {}

                    override fun onAnimationEnd(animation: Animation?) {
                        val aiFadeIn = AnimationUtils.loadAnimation(this@MainActivity, R.anim.ai_fade_in)
                        aiImage.visibility = View.VISIBLE
                        aiImage.startAnimation(aiFadeIn)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {}
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
