package app.horoscope.vedlabs.ui.activities


import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import app.horoscope.vedlabs.R
import app.horoscope.vedlabs.ui.utils.Utils
import kotlinx.android.synthetic.main.activity_histor_horror_scope.*

class HistoryHorrorScope : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.changeColor(this,"#F6FCFF",true)
        setContentView(R.layout.activity_histor_horror_scope)
        ivBack.setOnClickListener {
            finish()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvMoonSign.text = Html.fromHtml(
                    "<font color='#1F65A2'>Moon Sign</font> <font color='#000000'>Virgo</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            tvMoonSign.text =
                    Html.fromHtml("<font color='#1F65A2'>Moon Sign</font> <font color='#000000'>Virgo</font>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvNakshatra.text = Html.fromHtml(
                    "<font color='#1F65A2'>Nakshtra</font> <font color='#000000'>Virgo</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            tvNakshatra.text =
                    Html.fromHtml("<font color='#1F65A2'>Nakshtra</font> <font color='#000000'>Virgo</font>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvHealth.text = Html.fromHtml(
                    "<font color='#1F65A2'>Health</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            tvHealth.text =
                    Html.fromHtml("<font color='#1F65A2'>Health</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>")
        }

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      tvEmotions.text = Html.fromHtml(
                    "<font color='#1F65A2'>Emotions</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
      tvEmotions.text =
                    Html.fromHtml("<font color='#1F65A2'>Emotions</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      tvProfession.text = Html.fromHtml(
                    "<font color='#1F65A2'>Profession</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            tvProfession.text =
                    Html.fromHtml("<font color='#1F65A2'>Profession</font> <font color='#000000'>: Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore</font>")
        }


    }
}
