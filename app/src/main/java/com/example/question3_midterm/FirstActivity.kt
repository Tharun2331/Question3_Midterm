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

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val num1: EditText = findViewById(R.id.num1)
        val num2: EditText = findViewById(R.id.num2)
        val cal: Button = findViewById(R.id.Calculate)
        val spinner: Spinner = findViewById(R.id.spinner)
        var flag: String = "Sum"
        var options = arrayOf("Sum", "Subtraction", "Multiply", "Division")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        cal.setOnClickListener {
            val x: Int = num1.text.toString().toInt()
            val y: Int = num2.text.toString().toInt()

            val result: Int = when (flag) {
                "Sum" -> sum(x, y)
                "Subtraction" -> subtract(x, y)
                "Multiply" -> multiply(x, y)
                "Division" -> divide(x, y)
                else -> 0
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", result)
            startActivity(intent)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                flag = options[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun sum(x: Int, y: Int): Int = x + y
    private fun subtract(x: Int, y: Int): Int = x - y
    private fun multiply(x: Int, y: Int): Int = x * y
    private fun divide(x: Int, y: Int): Int = x / y
}
