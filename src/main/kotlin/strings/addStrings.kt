package strings

import kotlin.math.min

fun main() {
    println(addStrings("123", "11"))
}

fun addStrings(num1: String, num2: String): String {
    val result = StringBuilder()
    var p1 = num1.length - 1
    var p2 = num2.length - 1

    var carry = 0
    val base = 10
    while (p1 >= 0 || p2 >= 0) {
        var d1 = 0
        var d2 = 0

        if (p1 >= 0) {
            d1 = num1[p1--] - '0'
        }
        if (p2 >= 0) {
            d2 = num2[p2--] - '0'
        }

        var sum = d1 + d2 + carry

        if (sum >= base) {
            carry = 1
            sum = sum - base
        } else {
            carry = 0
        }
        result.append(sum)
    }
    if (carry > 0) {
        result.append(carry)
    }
    return result.reversed().toString()
}