package app.horoscope.vedlabs.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_user_detail.*
import org.json.JSONObject
import java.util.HashMap

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#E1F0FF",true)

        setContentView(R.layout.activity_splash)
        val animation = AlphaAnimation(0.2f, 1.0f)
        animation.duration = 2000
        animation.startOffset = 0
        animation.fillAfter = true
        ivLogo.animation = animation

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {


            }
            override fun onAnimationEnd(p0: Animation?) {
                startActivity(Intent(this@SplashActivity, SelectLanguageActivity::class.java))
                finishAffinity()
            }
            override fun onAnimationStart(p0: Animation?) {
            }
        })

    }
}
