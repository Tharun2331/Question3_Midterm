package com.example.question3_midterm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg1 = bundle.getString("key1")
            val msg2 = bundle.getString("key1")

            Toast.makeText(this,msg1, Toast.LENGTH_SHORT).show()
            Toast.makeText(this,msg2, Toast.LENGTH_SHORT).show()
        }



        }
    }
