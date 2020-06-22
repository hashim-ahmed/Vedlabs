package app.horoscope.vedlabs.ui.activities


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.RoundView
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#FFFFFF",true)
        setContentView(R.layout.activity_profile)
        btnContinue.background = RoundView(Color.parseColor("#000000"), Utils.getRadius(100f))
        btnEdit.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#000000"))

        btnEdit.setOnClickListener {
            val intent= Intent(this,EditProfileActivity::class.java)
            Utils.routeToActivity(intent,this)
        }

        btnContinue.setOnClickListener {
            val intent= Intent(this,HorrorScopeProfile::class.java)
            Utils.routeToActivity(intent,this)
        }

    }
}
