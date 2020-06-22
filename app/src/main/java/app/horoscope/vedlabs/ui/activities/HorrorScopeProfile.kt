package app.horoscope.vedlabs.ui.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.adapter.AdapterHorrorScope
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_horro_scope_profile.*

class HorrorScopeProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#F6FCFF",true)
        setContentView(R.layout.activity_horro_scope_profile)
        rvRecyler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvRecyler.adapter=AdapterHorrorScope(this)

        tvProfile.setOnClickListener {
            val intent= Intent(this,HistoryHorrorScope::class.java)
            Utils.routeToActivity(intent,this)
        }

    }
}
