package com.yjh.yjhactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

/*
* 1. 在 Activity 中使用 Menu
* 2. finish() 销毁当前Activity
* 3. 隐式 Intent 跳转到浏览器网页
* 4. 向下一个 Activity 传递数据
* 5. 返回数据给上一个 Activity
* */
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        back() //2. finish() 销毁当前Activity

        moveToBaidu() //3. 隐式 Intent 跳转到浏览器网页

        moveToSecondActivity() //4. 向下一个 Activity 传递数据

        moveAndBackToSecondActivity() //5. 返回数据给上一个 Activity

    }

    private fun moveAndBackToSecondActivity() {
        val button: Button = findViewById(R.id.changeBtn3)
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    //5. 返回数据给上一个 Activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if (resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this, "returned data is $returnedData", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToSecondActivity() {
        val button: Button = findViewById(R.id.changeBtn2)
        button.setOnClickListener{
            val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data", data)
            startActivity(intent)
        }
    }

    private fun moveToBaidu() {
        val button: Button = findViewById(R.id.changeBtn1)
        button.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }
    }

    private fun back() {
        val button: Button = findViewById(R.id.backBtn)
        button.setOnClickListener {
            finish()
        }
    }

    //1. 在 Activity 中使用 Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true //返回true表示允许创建的菜单显示
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }
}