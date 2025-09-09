package strings.easy

import java.util.TreeMap


fun main() {
    val x by lazy { "Hello" }
    mapTest()
    println(x)
}

fun mapTest() {
    // Create a TreeMap
//    val employeeMap = TreeMap<Int, String>()
//
//    // Add key-value pairs
//    employeeMap[103] = "Alice"
//    employeeMap[101] = "Bob"
//    employeeMap[102] = "Charlie"
//    employeeMap[105] = "David"
//
//    println("Original map: $employeeMap")
//    // Output will be sorted by key: {101=Bob, 102=Charlie, 103=Alice, 105=David}
//
//    // Accessing an element
//    val employeeName = employeeMap[102]
//    println("Employee with ID 102 is: $employeeName") // Output: Charlie
//
//    // Iterating through the sorted map
//    println("Iterating through the sorted map:")
//    employeeMap.forEach { (id, name) ->
//        println("ID: $id, Name: $name")
//    }

    val array = intArrayOf(1, 2, 3, 4, 1, 4, 2, 5, 6, 2, 5, 8, 1, 2, 3);
    val k = 3
    val frequencyMap = mutableMapOf<Int, Int>()
    for (i in array) {
        frequencyMap[i] = frequencyMap.getOrDefault(i, 0) + 1
    }

    val bucket = Array<MutableList<Int>?>(array.size + 1) { null }

    for ((key, frequency) in frequencyMap) {
       if(bucket.get(frequency) == null) {
           bucket[frequency] = mutableListOf()
       }
        bucket[frequency]?.add(key)

    }
    val result = mutableListOf<Int>()
    for (i in bucket.size - 1 downTo 0) {
        if(bucket[i] == null) continue
        for (key in bucket[i]!!) {
            result.add(key)
        }
        if(result.size >= k) {
            break
        }
    }
    println(result)
}