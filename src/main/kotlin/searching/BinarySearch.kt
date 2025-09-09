package searching

fun main() {
    val result = binarySearch(intArrayOf(1, 2, 4, 5, 7, 10, 12, 14, 15, 18), 18)
    println(result)
}

/**
 * To avoid this integer overflow, the midpoint m should be calculated using the following formula:
 * Code
 *
 * m = l + (r - l) / 2
 * Explanation of the Solution:
 * This formula calculates the distance between r and l (r - l), then divides that distance by 2, and finally adds the result to l.
 * Since r is always greater than or equal to l in a valid binary search, (r - l) will always be a non-negative value.
 * This approach avoids the intermediate sum (l + r), thereby preventing the potential for integer overflow, even when l and r are very large.
 * */
fun binarySearch(array: IntArray, search: Int): Int {
    var start = 0
    var end = array.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (array[mid] == search) {
            return mid
        }

        if (array[mid] < search) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return -1
}