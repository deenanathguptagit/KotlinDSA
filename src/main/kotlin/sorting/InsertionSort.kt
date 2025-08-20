package sorting

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]  // Current element to be inserted
        var j = i - 1     // Start comparing with the previous element

        // Shift elements greater than `key` to the right
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]  // Move the larger element forward
            j--
        }
        arr[j + 1] = key  // Place `key` in its correct position
    }
}

fun main() {
    val array = intArrayOf(1, 4, 2, 6, 3, 9, 6, 0)
    insertionSort(array)
    print(array.joinToString())
}