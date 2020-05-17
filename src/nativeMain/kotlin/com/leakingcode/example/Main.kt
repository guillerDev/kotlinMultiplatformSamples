package com.leakingcode.example

import com.leakingcode.example.library.MyKotlinClass
import com.leakingcode.example.library.sumTwoIntegers

fun main() {
    val myClass = MyKotlinClass()

    val rsp = myClass.hello("leakingcode.com")
    val x = sumTwoIntegers(2, 2)

    println(rsp)
    println("This is a kotlin native program  and 2 + 2 are $x")
}