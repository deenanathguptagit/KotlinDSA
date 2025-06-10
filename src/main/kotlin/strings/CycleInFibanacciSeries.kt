package strings

/*
* Write a function which returns, if exists, the cycle length in the sequence of
* the last digit of a Fibonacci sequence
* */
fun findFibonacciLastDigitCycle(): Int {
    val seen = mutableListOf<Pair<Int, Int>>()
    var a = 0
    var b = 1

    while (true) {
        val lastDigitPair = Pair(a % 10, b % 10)
        if (lastDigitPair in seen) {
            return seen.size // Cycle detected
        }
        seen.add(lastDigitPair)

        val temp = (a + b) % 10
        a = b
        b = temp
    }
}

fun main() {
    println("Cycle length: ${findFibonacciLastDigitCycle()}")
}
