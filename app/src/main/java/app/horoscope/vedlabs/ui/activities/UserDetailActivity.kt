package app.horoscope.vedlabs.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.RoundView
import app.horoscope.vedlabs.ui.utils.Utils
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#FFFFFF",true)
        setContentView(R.layout.activity_user_detail)
        ivBack.setOnClickListener {
            finish()
        }
        btnContinue.background = RoundView(Color.parseColor("#000000"), Utils.getRadius(100f))
        etFirstName.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        etLastName.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        etDob.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        etCity.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        spinner.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        spinnerTwo.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        spinnerThree.background = RoundView(Color.parseColor("#FFFFFF"), Utils.getRadius(100f),true,Color.parseColor("#E1E1E1"))
        spinner.setItems("1", "2","3","4","5","6","7")
        spinner.setOnItemSelectedListener { view, _, _, item ->

        }
        spinnerTwo.setItems("1", "2","3","4","5","6","7")
        spinner.setOnItemSelectedListener { view, _, _, item ->

        }
        spinnerThree.setItems("AM","PM")
        spinner.setOnItemSelectedListener { view, _, _, item ->

        }
        tvMale.setOnClickListener {
            selected(0)
        }
        tvFemale.setOnClickListener {
            selected(1)
        }

        ivUncheck.setOnClickListener {
            if (ivUncheck.isSelected){
                ivUncheck.isSelected=false
                ivUncheck.setImageResource(R.drawable.ic_uncheck)
            }else{
                ivUncheck.isSelected=true
                ivUncheck.setImageResource(R.drawable.ic_right_check)
            }



        }
        btnContinue.setOnClickListener {
            val intent= Intent(this,ProfileActivity::class.java)
            Utils.routeToActivity(intent,this)
        }

    }

    private fun selected(type: Int) {
        if (type==0){
            tvMale.setBackgroundResource(R.drawable.round_black)
            tvMale.setTextColor(Color.WHITE)
            tvFemale.setBackgroundResource(R.drawable.round_grey)
            tvFemale.setTextColor(Color.parseColor("#656565"))

        }else if(type==1){
            tvFemale.setBackgroundResource(R.drawable.round_black)
            tvFemale.setTextColor(Color.WHITE)
            tvMale.setBackgroundResource(R.drawable.round_grey)
            tvMale.setTextColor(Color.parseColor("#656565"))
        }
    }
}
