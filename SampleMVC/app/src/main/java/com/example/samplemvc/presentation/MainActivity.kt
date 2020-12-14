package com.example.samplemvc.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.samplemvc.R
import com.example.samplemvc.model.Model
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {
    // In MVC Pattern , View and Controller , both can access the model
    // In Android , Activity & fragment are view and Controller
    // because , this code can access view's controller

    // Model
    private lateinit var myModel: Model

    // View
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 모델 초기화
        // observer Activity 와 observable Model 사이의 관계 생성
        myModel = Model(lifecycle)

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        // 첫번째 add Click Listener
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

        // 두번쨰 , 이 방법의 단점은 mClickListener라는 객체를 생성해 이를 object클래스인 View.OnClickListener를 담아서 사용하는데 불필요한 객체가 많이 들어간다.
        /*button1.setOnClickListener(mClickListener)*/

        // 세번쨰 , 익명객체 방법으로 object를 통해 View.OnClickListener를 생성하여 함수에 달아줄 수 있도록 한다.
        /*button1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        })*/

        // 네번째 , 가장 대중적이고 간략한 표현이지만 생략된 것이 많아 초보자가 읽기엔 불편함
        /*button1.setOnClickListener {

        }*/
    }

    // function view update
    // the values are modified by the model
    @SuppressLint("SetTextI18n")
    override fun update(p0: Observable?, p1: Any?) {
        button1.text = "Count : " + myModel.getValueAtIndex(0)
        button2.text = "Count : " + myModel.getValueAtIndex(1)
        button3.text = "Count : " + myModel.getValueAtIndex(2)
    }

    // Listener를 다는 3가지의 방법
    // 첫번쨰
    override fun onClick(view: View?) {
        return when (view!!.id) {
            R.id.button -> myModel.setValueAtIndex(0)
            R.id.button2 -> myModel.setValueAtIndex(1)
            R.id.button3 -> myModel.setValueAtIndex(2)
            else -> Unit
        }
    }

    // 두번째
    /*private val mClickListener : View.OnClickListener = object : View.OnClickListener{
        override fun onClick(p0: View?) {

        }
    }*/

}