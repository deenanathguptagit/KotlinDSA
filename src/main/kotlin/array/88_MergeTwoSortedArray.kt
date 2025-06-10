package array

fun main() {
    var a1 = intArrayOf(1, 2, 3, 0, 0, 0)
    var a2 = intArrayOf(2, 5, 6)
    var m = 3
    var n = 3
    merge(a1, m, a2, n)
    println(a1.joinToString())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1;
    var j = n - 1
    var k = m + n - 1

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
            k--
        } else {
            nums1[k] = nums2[j]
            j--
            k--
        }
    }
}
