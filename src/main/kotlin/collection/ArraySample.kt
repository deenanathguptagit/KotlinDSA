package collection

import java.util.Arrays

fun main() {
    val array: Array<Int> = arrayOf(1, 2, 3, 4)
    println(array.joinToString())
    array[10] = 10
    println(array.size)
    array[0] = 100
    var a = Array(10) { 0 }
    a.set(0,100)
    a[1] = 100
    val l = listOf(1, 0, 2)
}