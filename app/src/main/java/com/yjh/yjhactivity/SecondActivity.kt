package com.yjh.yjhactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //4. 向下一个 Activity 传递数据
        val extraData = intent.getStringExtra("extra_data")
        Toast.makeText(this, "extra data is $extraData", Toast.LENGTH_SHORT).show()

        //5. 返回数据给上一个 Activity
        val button: Button = findViewById(R.id.back)
        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("data_return", "hello, First Activity")
            setResult(RESULT_OK, intent)
            finish()
        }
    }


    //5. 返回数据给上一个 Activity
    //用户按back键
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "hello, First Activity")
        setResult(RESULT_OK, intent)
        finish()
    }
}