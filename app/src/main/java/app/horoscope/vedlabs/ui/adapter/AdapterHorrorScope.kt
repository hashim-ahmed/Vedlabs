package app.horoscope.vedlabs.ui.adapter

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.horoscope.vedlabs.R
import kotlinx.android.synthetic.main.item_horror_scope.view.*

class AdapterHorrorScope(private val context: Context) : RecyclerView.Adapter<AdapterHorrorScope.RecViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater
                .from(parent.context).inflate(R.layout.item_horror_scope, parent, false)
        return RecViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tvMoonSign.text = Html.fromHtml(
                    "<font color='#1F65A2'>Moon Sign</font> <font color='#000000'>Virgo</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            holder.tvMoonSign.text =
                    Html.fromHtml("<font color='#1F65A2'>Moon Sign</font> <font color='#000000'>Virgo</font>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tvNakshatra.text = Html.fromHtml(
                    "<font color='#1F65A2'>Nakshtra</font> <font color='#000000'>Virgo</font>",
                    Html.FROM_HTML_MODE_COMPACT
            )
        } else {
            holder.tvNakshatra.text =
                    Html.fromHtml("<font color='#1F65A2'>Nakshtra</font> <font color='#000000'>Virgo</font>")
        }


    }

    override fun getItemCount(): Int {
        return 2
    }

    inner class RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMoonSign: TextView = itemView.tvMoonSign
        val tvNakshatra: TextView = itemView.tvNakshatra
        val linearLayout: LinearLayout = itemView.linearLayout

    }
}