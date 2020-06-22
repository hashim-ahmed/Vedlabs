package app.horoscope.vedlabs.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_social.*

class SocialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#E1F0FF",true)
        setContentView(R.layout.activity_social)

        rltFacebook.setOnClickListener {
            val intent= Intent(this,UserDetailActivity::class.java)
            Utils.routeToActivity(intent,this)
        }

      rltGoogle.setOnClickListener {
            val intent= Intent(this,UserDetailActivity::class.java)
            Utils.routeToActivity(intent,this)
        }

    }
}
