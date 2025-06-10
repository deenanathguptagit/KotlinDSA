package collection
fun main() {
    val aList = Array(7) { 5 }
    aList[0] = 12
    aList[1] = 13
    println(aList.joinToString())
    val initArray = Array<Int>(3) { 0 }
    println(initArray.joinToString())
    val intArrays = IntArray(10)
    intArrays[0] = 10
    println(intArrays.joinToString())
    val booleanArray = BooleanArray(4)
    println(booleanArray.joinToString())
//    val d = Derived("abc","xyz")
    FilledRectangle().draw()
}

//open class Shape {
//    open fun draw() { /*...*/ }
//    fun fill() { /*...*/ }
//}
//
//open class Circle() : Shape() {
//     override fun draw() { /*...*/ }
//
//}
//
//class Rectangle: Circle() {
//    override fun draw() {
//
//    }
//}

open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}