package com.example.aliot1.lab1candroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    private val FORM1: Int = 1
    private val FORM2: Int = 2
    private var formula_flag: Int = 1
    private var memory_flag: Int = 1
    private var memoryValue1: Double = 0.0
    private var memoryValue2: Double = 0.0
    private var memoryValue3: Double = 0.0
    private var result: Double = 0.0
    private val MEM1: Int = 1
    private val MEM2: Int = 2
    private val MEM3: Int = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        radioFormula1 = findViewById(R.id.radioFormula1) as RadioButton
//        radioFormula2 = findViewById(R.id.radioFormula2) as RadioButton
//        formulaView=findViewById(R.id.formulaView) as ImageView
//        radioFormula1.setOnCheckedChangeListener({ button, b ->
//            FORMULA_FLAG = form1
//            setImage()
//        })
        radioMemoryListener()
        radioFormula2.setOnClickListener {
            formula_flag = FORM2
            setImage()
        }
        radioFormula1.setOnClickListener {
            formula_flag = FORM1
            setImage()
        }
        floatingButtonMC.setOnClickListener {
            setButtonMCListener()
        }

        float_result.setOnClickListener {

            if (formula_flag == FORM1) {
                calculateFormula1()
            } else if (formula_flag == FORM2) {
                calculateFormula2()
            }

        }
        floatingButtonMPlus.setOnClickListener {
            setButtonMPlusListener()
        }

    }

    private fun radioMemoryListener() {
        radioMem1.setOnClickListener {
            memory_flag=MEM1
        }
        radioMem2.setOnClickListener {
            memory_flag=MEM2
        }
        radioMem3.setOnClickListener {
            memory_flag=MEM3
        }
    }

    private fun setButtonMPlusListener() {
        if (memory_flag == MEM1) {

            memoryValue1 = memoryValue1 + result
            textMem1.setText(memoryValue1.toString())
        } else if (memory_flag == MEM2) {
            memoryValue2 = memoryValue2 + result
            textMem2.setText(memoryValue2.toString())
        } else if (memory_flag == MEM3) {
            memoryValue3 = memoryValue3 + result
            textMem3.setText(memoryValue3.toString())
        }
    }

    private fun calculateFormula2() {

        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        try {
            x = java.lang.Double.valueOf(inputX.getText().toString())
        } catch(e: Exception) {
            x = 0.0
        }
        try {
            y = java.lang.Double.valueOf(inputY.getText().toString())
        } catch (e: Exception) {
            y = 0.0
        }
        try {
            z = java.lang.Double.valueOf(inputZ.getText().toString())
        } catch (e: Exception) {
            z = 0.0
        }

        result = Math.pow(Math.cos(Math.exp(x)) + Math.pow(Math.log(1 + y), 2.0)
                + Math.sqrt(Math.exp(Math.cos(x)) + Math.sin(Math.PI * z) * Math.sin(Math.PI * z))
                + Math.sqrt(1 / x) + Math.cos(Math.pow(y, 2.0)), Math.sin(z))
        result_view.setText(result.toString())
    }

    private fun calculateFormula1() {
        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        try {
            x = java.lang.Double.valueOf(inputX.getText().toString())
        } catch(e: Exception) {
            x = 0.0
        }
        try {
            y = java.lang.Double.valueOf(inputY.getText().toString())
        } catch (e: Exception) {
            y = 0.0
        }
        try {
            z = java.lang.Double.valueOf(inputZ.getText().toString())
        } catch (e: Exception) {
            z = 0.0
        }


        result = Math.sin(Math.log(y) + Math.sin(Math.PI * y * y)) *
                Math.sqrt(Math.sqrt(Math.pow(x, 2.0) + Math.sin(z) + Math.exp(Math.cos(z))))
        result_view.setText(result.toString())
    }

    private fun setButtonMCListener() {
        if (memory_flag == MEM1) {
            memoryValue1 = 0.0
            textMem1.setText(memoryValue1.toString())
        } else if (memory_flag == MEM2) {
            memoryValue2 = 0.0
            textMem2.setText(memoryValue2.toString())
        } else if (memory_flag == MEM3) {
            memoryValue3 = 0.0
            textMem3.setText(memoryValue3.toString())
        }
    }


    private fun setImage() {
        if (formula_flag == FORM1) {
            formulaView.setImageResource(R.mipmap.formula1)
        } else {
            formulaView.setImageResource(R.mipmap.formula2)
        }
    }
}
