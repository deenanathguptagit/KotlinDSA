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
//    val base = BaseImpl(10)
//    Derived(base).printMessage()
//    Derived(base).printMessageLine()
//    val result = operate(1, 2, ::add)
//    println(result)

//    checkType<String>("Hello")   // ✅ Output: Yes, it is String
//    checkType<Int>("Hello")      // ❌ Output: Nope!
//    val names = listOf("Alice", "Bob","Deena")
//    val ages = listOf(25, 30,40)
//    val pairs = names.zip(ages) // [("Alice", 25), ("Bob", 30)]
//    println(pairs)
//    val result = null + null
//    println(null+null)
//
//    val res = operate()
//    println(res(10,20))

    println( 'x')

}

fun operate(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    return sum(a, b)
}

fun operate(): (Int, Int) -> Int {
    return ::add
}

fun add(x: Int, y: Int) = x + y
inline fun <reified T> checkType(obj: Any) {
    if (obj is T) {
        println("Yes, it is ${T::class.simpleName}")
    } else {
        println("Nope!")
    }
}

