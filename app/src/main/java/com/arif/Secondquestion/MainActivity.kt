package com.arif.Secondquestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var radioButton: RadioButton
    lateinit var english: CheckBox
    lateinit var hindi: CheckBox
    lateinit var urdu: CheckBox
    lateinit var french: CheckBox
    lateinit var german: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        english = findViewById(R.id.checkBox1)
        hindi = findViewById(R.id.checkBox2)
        urdu = findViewById(R.id.checkBox3)
        french = findViewById(R.id.checkBox4)
        german = findViewById(R.id.checkBox5)

        btnSubmit.setOnClickListener {
            var result = StringBuilder()
            var resultBox = StringBuilder()
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val id:Int = radioGroup.checkedRadioButtonId
            if (id != -1)
            {
                radioButton = findViewById(id)
                result.append("Current CGPA: " + radioButton.text.toString() + "\n")
            }

            if(english.isChecked)
                resultBox.append("English ")
            if(hindi.isChecked)
                resultBox.append("Hindi ")
            if(urdu.isChecked)
                resultBox.append("Urdu ")
            if(french.isChecked)
                resultBox.append("French ")
            if(german.isChecked)
                resultBox.append("German ")
            if(resultBox.isNotEmpty())
                Toast.makeText(this, "$result Language Known: $resultBox", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }
}