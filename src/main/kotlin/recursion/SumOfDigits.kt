package recursion

fun main() {
    val result = sumOfDigit(2135)
    println()
    println(result)
}

fun sumOfDigit(n: Int): Int {
    println(n)
    return if (n == 0)
        0
    else
        n % 10 + sumOfDigit(n / 10)
}