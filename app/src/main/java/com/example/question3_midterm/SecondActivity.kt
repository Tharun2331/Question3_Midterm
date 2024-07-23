package com.example.question3_midterm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fName: EditText = findViewById(R.id.fName)
        val lName: EditText = findViewById(R.id.lName)
        val age: EditText = findViewById(R.id.age)
        val submit: Button = findViewById(R.id.submit)
        val spinner: Spinner = findViewById(R.id.spinner)

        var flag: String = "firstName"
        var options = arrayOf("firstName", "lastName", "age")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        submit.setOnClickListener {
            val fName: String = fName.text.toString()
            val lName: String = lName.text.toString()
            val age: Int = age.text.toString().toInt()

            val message: String = when (flag) {
                "firstName" -> fName
                "lastName" -> lName
                "age" -> age.toString()
                else -> ""
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                flag = options[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
