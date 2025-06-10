package recursion

fun main() {
    val result = factorial(5)
    println()
    println(result)
}

fun factorial(n: Int): Int {
    return if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
}