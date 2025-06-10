package recursion

fun main() {
    println(sumOfNumber(5))
}

fun sumOfNumber(n: Int): Int {
    return if (n == 1) 1
    else n + sumOfNumber(n - 1)
}