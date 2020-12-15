package com.example.samplemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() , Contract.View {

    private lateinit var textView : TextView
    private lateinit var button : Button
    private lateinit var progressbar : ProgressBar
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressbar = findViewById(R.id.progressBar)
        presenter = Presenter(this,Model())

        button.setOnClickListener(View.OnClickListener { presenter.onButtonClick() })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progressbar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressbar.visibility = View.INVISIBLE
        textView.visibility = View.VISIBLE
    }

    override fun setString(string: String) {
        textView.text = string
    }

}