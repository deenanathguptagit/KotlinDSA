package array

fun missingNumbers(arr: Array<Int>, brr: Array<Int>): Array<Int> {
    val freqMap = mutableMapOf<Int, Int>()
    for (a in brr) {
        freqMap[a] = freqMap.getOrDefault(a, 0) + 1
    }
    for (a in arr) {
        freqMap[a] = freqMap.getOrDefault(a, 0) - 1
    }
    val missingList = mutableListOf<Int>()
    for ((num, count) in freqMap) {
        var c = count
        while (c > 0) {
            missingList.add(num)
            c--
        }
    }
    return missingList.sorted().toTypedArray()
}

fun main() {
    val res = missingNumbers(arrayOf(7, 2, 5, 3, 5, 3), arrayOf(7, 2, 5, 4, 6, 3, 5, 3, 1, 1))
    println(res.joinToString())
}
