package slidingwindow

fun main() {
    moveZeroes(intArrayOf(1, 0))
}

fun moveZeroes(nums: IntArray): Unit {
    val size = nums.size - 1
    var left = 0
    var right = 0
    while (right <= size) {
        if (nums[right] != 0) {
            var temp = nums[right]
            nums[right] = nums[left]
            nums[left] = temp
            left++
        }
        right++
    }
    println(nums.joinToString())
}