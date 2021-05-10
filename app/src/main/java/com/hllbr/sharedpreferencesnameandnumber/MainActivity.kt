package com.hllbr.sharedpreferencesnameandnumber

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var agesharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null
    lateinit var namesharedPreferences : SharedPreferences
    var nameFromPreferences : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        agesharedPreferences = this.getSharedPreferences("com.hllbr.storingdatakotlin",
            Context.MODE_PRIVATE)

        namesharedPreferences = this.getSharedPreferences("com.hllbr.storingdatakotlin",
            Context.MODE_PRIVATE)

        ageFromPreferences = agesharedPreferences.getInt("age",-1)

        nameFromPreferences = namesharedPreferences.getString("name",null)

        if (ageFromPreferences == -1){
            textView.text = "YOUR AGE : "
        }else{
            textView.text= "YOUR AGE : ${ageFromPreferences}"
        }
        if (nameFromPreferences == null){
            textViewName.text = "YOUR NAME :"
        }else{
            textViewName.text= "YOUR NAME : ${nameFromPreferences}"
        }
    }
    fun nameDelete(view: View){
    nameFromPreferences = namesharedPreferences.getString("name",null)
        if (nameFromPreferences !=null){
            namesharedPreferences.edit().remove("name").apply()
            textViewName.text = "MYNAME : !"
        }
    }
    fun nameSave(view:View){
    val myName = editTextName.text.toString()
        if (myName != null){
            textViewName.text = "myName : ${myName}"
            namesharedPreferences.edit().putString("name",myName).apply()
        }

    }
    fun Delete(view : View){
    ageFromPreferences = agesharedPreferences.getInt("age",-1)
    if (ageFromPreferences != -1){
        agesharedPreferences.edit().remove("age").apply()
        textView.text = "MYAGE : !"
    }
    }
    fun Save(view :View){
        val myAge =editText.text.toString().toIntOrNull()
            if(myAge != null){
                textView.text = "MyAge : ${myAge}"
                agesharedPreferences.edit().putInt("age",myAge).apply()
            }
    }
}