package array.medium

/*
 * Problem Statement: Top K Frequent Elements Given a non-empty array of integers,
 * you are required to return the k most frequent elements.

Example
Input: nums = [1, 1, 1, 2, 2, 3], k = 2
Output: [1, 2]
nums = [10, 20, 30, 40, 50, 10, 20, 30, 10, 20, 10]
k = 1
Expected Output: [10]
*/
fun main() {
    val input = intArrayOf(10, 20, 30, 40, 50, 10, 20, 30, 10, 10)
    println(findKthElements(input, 2).joinToString())
}

fun findKthElements(arr: IntArray, k: Int):IntArray {
    val frequencyMap = mutableMapOf<Int, Int>()
    for (num in arr) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    // Step 2: Bucket sort by frequency
    val maxFreq = frequencyMap.values.maxOrNull() ?: 0
    val buckets = Array<MutableList<Int>>(maxFreq + 1) { mutableListOf() }
    for ((num, freq) in frequencyMap) {
        buckets[freq].add(num)
    }

    // Step 3: Extract top k elements
    val result = mutableListOf<Int>()
    for (freq in maxFreq downTo 1) {
        for (num in buckets[freq]) {
            result.add(num)
            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }

    return result.toIntArray()
}