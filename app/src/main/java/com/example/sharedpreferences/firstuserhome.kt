package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class firstuserhome : AppCompatActivity() {
    lateinit var pref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstuserhome)

        var logout:Button=findViewById(R.id.logout)
        var tv:TextView=findViewById(R.id.tv)

        pref=getSharedPreferences("TP1", Context.MODE_PRIVATE)
        val name=pref.getString("Name","")
        tv.text=name
        logout.setOnClickListener(){
            val editor:SharedPreferences.Editor=pref.edit()
            editor.clear()
            editor.apply()

            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}