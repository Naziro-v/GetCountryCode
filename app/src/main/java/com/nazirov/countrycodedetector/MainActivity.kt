package com.nazirov.countrycodedetector

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.TelephonyManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,getCountry(),Toast.LENGTH_SHORT).show()
    }
    private fun getCountry() : String {
        var countryId :String
        var countryCode :String? = null

        val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        countryId = telephonyManager.simCountryIso.uppercase()

        val arrContryCode = this.resources.getStringArray(R.array.DialingCountryCode)

        for (i in arrContryCode.indices) {
            var arrDial = arrContryCode[i].split(",").toTypedArray()
            if (arrDial[1].trim()==countryId.trim()) {
                countryCode=arrDial[0]
                break
            }
        }
        return countryCode!!
    }
}