package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sp:SharedPreferences
    var isRemember=false

    lateinit var sp1: SharedPreferences
    var isRemember1=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login:Button = findViewById(R.id.login)
        val nameEt:EditText=findViewById(R.id.name1)
        //val cb:CheckBox=findViewById(R.id.checkBox)
        val su:Button=findViewById(R.id.seconduser)
        

        sp=getSharedPreferences("TP1", Context.MODE_PRIVATE)
        isRemember=sp.getBoolean("CB1",false)

        sp1=getSharedPreferences("TP2", Context.MODE_PRIVATE)
        isRemember1=sp1.getBoolean("CB2",false)

        if(isRemember)
        {
            val intent= Intent(this,firstuserhome::class.java)
            startActivity(intent)
            finish()
        }

        if(isRemember1)
        {
            val intent= Intent(this,seconduserhome::class.java)
            startActivity(intent)
            finish()
        }

        login.setOnClickListener(){
            val name:String=nameEt.text.toString()
            //val checked:Boolean=cb.isChecked

            val editor:SharedPreferences.Editor=sp.edit()
            editor.putString("Name",name)
            //editor.putBoolean("CB1",checked)
            editor.putBoolean("CB1",true)
            editor.apply()
            Toast.makeText(this@MainActivity,"Information Saved",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,firstuserhome::class.java)
            startActivity(intent)
            finish()
        }

        su.setOnClickListener(){
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

    }

}