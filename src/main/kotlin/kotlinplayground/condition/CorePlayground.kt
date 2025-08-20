package kotlinplayground.condition

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {
    override fun printMessage() {
        println(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived(b: Base) : Base by b {
    override fun printMessage() {
        println("printMessage")
    }

    override fun printMessageLine() {
        println("printMessageLine")
    }
}

fun main() {
    val approach1 = operate(3, 4, ::sum)
    println(approach1)
    val approach2 = operate(2, 3) { x, y ->
        x * y
    }
    println(approach2)

    val approach3 = operate(4,5, add)
    println(approach3)
}

val add: (Int, Int) -> Int = { x, y -> x + y }

inline fun <reified T> checkType(obj: Any) {
    if (obj is T) {
        println("Yes, it is ${T::class.simpleName}")
    } else {
        println("Nope!")
    }
}

fun operate(num1: Int, num2: Int, sum: (Int, Int) -> Int): Int {
    return sum(num1, num2)
}

fun sum(num1: Int, num2: Int) = num1 + num2


