package org.zhangzhewen.kotlin

var age: Int = 18
val name: String = "zhang zhe wen"
val name2: String? = null

fun main(): Unit {
    test {
        run {
            println("3")
        }
    }
    println("2")
}

inline fun test(noinline a: () -> Unit) {
    a()
    println("1")
    return
}

fun a(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) block()
}

object Person {
    @JvmStatic
    fun say(msg: String) {
        println(msg)
    }
}

