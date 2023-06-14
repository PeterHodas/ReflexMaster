package com.example.reflexmaster

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.reflexmaster.database.Score
import java.text.SimpleDateFormat

/**
 * Metódy ktoré dávajú čas a dáta do správneho formátu ktoré su neskôr volané v iných metódach
 *
 */

// prehodenie na dátum a čas uloženia
@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(systemTime: Long): String {
    return SimpleDateFormat("EEEE MMM-dd-yyyy' V čase: 'HH:mm")
        .format(systemTime).toString()
}

// rozdelenie dat do riadkov
fun formatNights(scr: List<Score>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.vysledky))
        scr.forEach {
            append("<br>")
            append("<br>")
            append(resources.getString(R.string.str_score))
            append("\t${(it.score.toLong())}<br>")

            append(resources.getString(R.string.str_cas))
            append("\t${convertLongToDateString(it.timeMilli)}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}