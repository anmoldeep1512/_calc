package com.example.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.calculator.R
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private fun evalExp(string: String, clear: Boolean) {
        if (clear) {
            result.text = ""
            exp.append(string)
        } else {
            exp.append(result.text)
            exp.append(string)
            result.text = ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener {
            evalExp("1", clear = true)
        }

        two.setOnClickListener {
            evalExp("2", clear = true)
        }

        three.setOnClickListener {
            evalExp("3", clear = true)
        }

        four.setOnClickListener {
            evalExp("4", clear = true)
        }

        five.setOnClickListener {
            evalExp("5", clear = true)
        }

        six.setOnClickListener {
            evalExp("6", clear = true)
        }

        seven.setOnClickListener {
            evalExp("7", clear = true)
        }

        eight.setOnClickListener {
            evalExp("8", clear = true)
        }

        nine.setOnClickListener {
            evalExp("9", clear = true)
        }

        zero.setOnClickListener {
            evalExp("0", clear = true)
        }

        plus.setOnClickListener {
            evalExp("+", clear = true)
        }

        minus.setOnClickListener {
            evalExp("-", clear = true)
        }

        mult.setOnClickListener {
            evalExp("*", clear = true)
        }

        divide.setOnClickListener {
            evalExp("/", clear = true)
        }

        decimal.setOnClickListener {
            evalExp(".", clear = true)
        }

        clear.setOnClickListener {
            exp.text = ""
            result.text = ""
        }

        equals.setOnClickListener {
            val text = exp.text.toString()
            val exp1 = ExpressionBuilder(text).build()

            val result1 = exp1.evaluate()
            val longResult = result1.toLong()
            if (result1 == longResult.toDouble()) {
                result.text = longResult.toString()
            } else {
                result.text = result1.toString()
            }
        }

        delete.setOnClickListener {
            val text = exp.text.toString()
            if (text.isNotEmpty()) {
                exp.text = text.drop(1)
            }

            result.text = ""
        }
    }
}