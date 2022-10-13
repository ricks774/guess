package com.ricks.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "secret:" + secretNumber.secret)
    }

    fun check(view: View){
        var n = ed_number.text.toString().toInt()
        Log.d("MainActivity", "number:" + n)
        val diff = secretNumber.vaildate(n)
        var message = "You got it"
        if (diff < 0){
            message = "Bigger"
        }else if (diff > 0){
            message = "Smaller"
        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)   // 從哪個元件
            .setTitle("Message")    // 對話框標題
            .setMessage(message)    // 對話框顯示的內容
            .setPositiveButton("OK",null)   // 對話框按鈕樣式(按鈕文字, 觸發事件)
            .show() // 顯示在畫面上
    }


}