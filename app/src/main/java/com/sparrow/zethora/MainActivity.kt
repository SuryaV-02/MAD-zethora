package com.sparrow.zethora

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.widget.*
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_fnt = findViewById<Button>(R.id.btn_fnt)
        val btn_color = findViewById<Button>(R.id.btn_color)
        val btn_bg = findViewById<Button>(R.id.btn_bg)
        val tv_title = findViewById<TextView>(R.id.tv_title)
        var float_size = 20f
        var current_text_size = 20
        var main_scr = findViewById<LinearLayout>(R.id.main_scr)

        val edt_title = findViewById<EditText>(R.id.edt_title)
        btn_fnt.setOnClickListener {
            Toast.makeText(this, "${tv_title.textSize}", Toast.LENGTH_SHORT).show()
            if(tv_title.textSize<=100){
                current_text_size += 5
                tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,current_text_size.toFloat())
            }else{
                current_text_size = 20
                tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,current_text_size.toFloat())
            }
        }

        btn_color.setOnClickListener {
            val color: Int = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            tv_title.setTextColor(color)
        }
        btn_bg.setOnClickListener {
            val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            main_scr.setBackgroundColor(color)
        }

        edt_title.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                tv_title.text = edt_title.text.toString()
            }

        })
    }
}