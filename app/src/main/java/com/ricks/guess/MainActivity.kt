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
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "secret:" + secretNumber.secret)
    }

    fun check(view: View){
        var n = ed_number.text.toString().toInt()
        Log.d(TAG, "number:" + n)
        val diff = secretNumber.vaildate(n)
        var message = getString(R.string.you_got_it)
        if (diff < 0){
            message = getString(R.string.bigger)
        }else if (diff > 0){
            message = getString(R.string.smaller)
        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)   // 從哪個元件
            .setTitle(getString(R.string.dailog_title))    // 對話框標題
            .setMessage(message)    // 對話框顯示的內容
            .setPositiveButton(getString(R.string.ok),null)   // 對話框按鈕樣式(按鈕文字, 觸發事件)
            .show() // 顯示在畫面上
    }


}