package com.example.moneyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idNumConvert)
        val rbUStoEuro = findViewById<RadioButton>(R.id.idUStoEuro)
        val rbEurotoUS = findViewById<RadioButton>(R.id.idEurotoUS)
        val txtResult = findViewById<TextView>(R.id.idConverterAmount)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat ("#.#")
            val dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 0.95
            var convertMeasureNum: Double?
            if (rbUStoEuro.isChecked){
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " euros"
                }else{
                    Toast.makeText(this@MainActivity, "Dollar amount must be less than $10,000.", Toast.LENGTH_LONG).show()
                }
            }
            if (rbEurotoUS.isChecked){
                if (dblMeasure <= 9467.50) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " dollars"
                }else{
                    Toast.makeText(this@MainActivity, "Euro amount must be less than €9,467.50.", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}