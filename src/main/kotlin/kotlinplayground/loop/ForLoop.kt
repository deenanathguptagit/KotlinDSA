package kotlinplayground.loop

fun main() {
    println("=== Basic Range Loops ===")
    // 1. Basic range loop (ascending)
    print("1. Ascending range (1..5): ")
    for (i in 1..5) {
        print("$i ")
    }
    println()

    // 2. Range loop with step
    print("2. Range with step (1..10 step 2): ")
    for (i in 1..10 step 2) {
        print("$i ")
    }
    println()

    // 3. Descending range
    print("3. Descending range (5 downTo 1): ")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()

    // 4. Descending range with step
    print("4. Descending with step (10 downTo 1 step 3): ")
    for (i in 10 downTo 1 step 3) {
        print("$i ")
    }
    println()

    // 5. Until loop (excludes upper bound)
    print("5. Until loop (1 until 5): ")
    for (i in 1 until 5) {
        print("$i ")
    }
    println("\n")

    println("=== Collection Loops ===")
    val fruits = listOf("Apple", "Banana", "Cherry", "Date")

    // 6. Loop through list elements
    print("6. List elements: ")
    for (fruit in fruits) {
        print("$fruit ")
    }
    println()

    // 7. Loop with index
    print("7. List with index: ")
    for ((index, fruit) in fruits.withIndex()) {
        print("$index:$fruit ")
    }
    println()

    // 8. Loop through array indices
    print("8. Array indices: ")
    for (i in fruits.indices) {
        print("$i:${fruits[i]} ")
    }
    println("\n")

    println("=== Map Loops ===")
    val map = mapOf(1 to "One", 2 to "Two", 3 to "Three")

    // 9. Loop through map entries
    print("9. Map entries: ")
    for ((key, value) in map) {
        print("$key=$value ")
    }
    println()

    // 10. Loop through map keys
    print("10. Map keys: ")
    for (key in map.keys) {
        print("$key ")
    }
    println()

    // 11. Loop through map values
    print("11. Map values: ")
    for (value in map.values) {
        print("$value ")
    }
    println("\n")

    println("=== String Loops ===")
    val text = "Kotlin"

    // 12. Loop through string characters
    print("12. String characters: ")
    for (ch in text) {
        print("$ch ")
    }
    println()

    // 13. Loop through string characters with index
    print("13. String with index: ")
    for ((i, ch) in text.withIndex()) {
        print("$i:$ch ")
    }
    println("\n")

    println("=== Special Loop Cases ===")
    // 14. Loop with destructuring in a list of pairs
    val pairs = listOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))
    print("14. Destructuring pairs: ")
    for ((num, name) in pairs) {
        print("$num=$name ")
    }
    println()

    // 15. Loop with custom iterator
    val customIterable = CustomIterable()
    print("15. Custom iterable: ")
    for (item in customIterable) {
        print("$item ")
    }
    println()

    // 16. Nested loops
    println("16. Nested loops:")
    for (i in 1..3) {
        for (j in 1..3) {
            print("($i,$j) ")
        }
        println()
    }
}

// Custom iterable class
class CustomIterable : Iterable<String> {
    override fun iterator(): Iterator<String> {
        return listOf("First", "Second", "Third").iterator()
    }
}