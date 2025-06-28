package array

//4, 5, 6, 7, 8,1,2 3
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    rightRotate(nums, 3)
    println(nums.joinToString())
}

fun leftRotate(nums: IntArray, k: Int): Unit {
    val copy = IntArray(k)
    for (i in 0..k - 1) {
        copy[i] = nums[i]
    }
    println("Copy ${copy.joinToString()}")
    var index = 0
    for (i in k..<nums.size) {
        nums[index] = nums[i]
        index++
    }
    println("Nums ${nums.joinToString()}")
    for (i in 0..<k) {
        nums[index] = copy[i]
        index++
    }
}

fun rightRotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    val steps = k % n  // If k == nums-size then rotation value will be same, hence to avoid the operation find modules value
    if (steps == 0) return

    val copy = IntArray(steps)
    var copyIndex = 0

    // Copy the last k elements
    for (i in n - steps until n) {
        copy[copyIndex] = nums[i]
        copyIndex++
    }
    println("Copy ${copy.joinToString()}")

    // Shift the rest to the right
    for (i in n - steps - 1 downTo 0) {
        nums[i + steps] = nums[i]
    }
    println("After shift: ${nums.joinToString()}")

    // Place copied elements at front
    for (i in 0 until steps) {
        nums[i] = copy[i]
    }
    println("Final: ${nums.joinToString()}")
}
