package array.medium

fun findDuplicate(nums: IntArray): Int {
    // Start a fast and slow pointer
    // until they meet
    var slow = 0
    var fast = 0

    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while(slow != fast)
    // As soon as they meet, move both
    // pointers at same speed until they
    // meet again
    slow = 0
    while(slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }
    return slow
}

fun main() {
    val result = findDuplicate(intArrayOf(1,3,4,2,2))
    println(result)
}