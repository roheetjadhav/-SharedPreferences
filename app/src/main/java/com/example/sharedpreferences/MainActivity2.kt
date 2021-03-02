package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var sp1: SharedPreferences
    var isRemember1=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val login2: Button = findViewById(R.id.login2)
        val nameEt2: EditText =findViewById(R.id.name2)
        //val cb2: CheckBox =findViewById(R.id.checkBox2)

        sp1=getSharedPreferences("TP2", Context.MODE_PRIVATE)
        /*isRemember1=sp1.getBoolean("CB2",false)

        if(isRemember1)
        {
            val intent= Intent(this,seconduserhome::class.java)
            startActivity(intent)
            finish()
        }*/

        login2.setOnClickListener(){
            val name2:String=nameEt2.text.toString()
            //val checked2:Boolean=cb2.isChecked

            val editor2:SharedPreferences.Editor=sp1.edit()
            editor2.putString("Name2",name2)
            //editor2.putBoolean("CB2",checked2)
            editor2.putBoolean("CB2",true)
            editor2.apply()
            Toast.makeText(this@MainActivity2,"Second Information Saved", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,seconduserhome::class.java)
            startActivity(intent)
            finish()
        }
    }
}