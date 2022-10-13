package com.ricks.guess

import java.util.Random

class SecretNumber{
    var secret = Random().nextInt(10) + 1   // 設定隨機亂數
    var count = 0   // 紀錄數數

    fun vaildate(number : Int) : Int{
        count ++
        return number - secret
    }

    fun  reset(){
        secret = Random().nextInt(10) + 1
        count = 0
    }
}

fun main(){
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.vaildate(2)}, count:${secretNumber.count}")
}