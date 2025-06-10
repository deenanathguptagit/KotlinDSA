package slidingwindow

fun main() {
    var input = intArrayOf(1, 1, 0, 1, 1, 1)
    println(findMaxConsecutiveOnes(input))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCount = 0
    var count = 0
    for (i in nums) {
        if (i == 1) {
            count++
        } else {
            maxCount = maxOf(maxCount, count)
            count = 0
        }
        maxCount = maxOf(maxCount, count)
    }

    return maxCount
}
