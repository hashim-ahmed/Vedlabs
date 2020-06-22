package app.horoscope.vedlabs.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.RoundView
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_select_lanuguage.*

class SelectLanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#E1F0FF",true)
        setContentView(R.layout.activity_select_lanuguage)
        btnNext.background = RoundView(Color.parseColor("#000000"), Utils.getRadius(100f))
        rltHindi.setOnClickListener {
            ivCheckHindi.visibility=View.VISIBLE
            ivCheckEnglish.visibility=View.GONE
        }
        rltEnglish.setOnClickListener {
            ivCheckEnglish.visibility=View.VISIBLE
            ivCheckHindi.visibility=View.GONE


        }


        btnNext.setOnClickListener {
            val intent= Intent(this,SocialActivity::class.java)
            Utils.routeToActivity(intent,this)
        }
    }
}
