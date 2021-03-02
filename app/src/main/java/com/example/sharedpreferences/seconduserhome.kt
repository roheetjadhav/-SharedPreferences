package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class seconduserhome : AppCompatActivity() {
    lateinit var pref2:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconduserhome)

        var logout2: Button =findViewById(R.id.logout2)
        var tv2: TextView =findViewById(R.id.tv2)

        pref2=getSharedPreferences("TP2", Context.MODE_PRIVATE)
        val name=pref2.getString("Name2","")
        tv2.text=name
        logout2.setOnClickListener(){
            val editor: SharedPreferences.Editor=pref2.edit()
            editor.clear()
            editor.apply()

            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }

}