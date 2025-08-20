package sorting

/**
First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
We keep doing this until we get all elements moved to correct position.
 O(n*n)
 */
fun selectionSort(array: IntArray) {
    for (i in 0 until array.size - 2) {
        var min = i
        var swapped = false // To track if a swap happened
        // Inner loop to find the minimum element
        for (j in i + 1 until array.size) {
            if (array[j] < array[min]) {
                min = j
            }
        }

        // Only swap if a new minimum is found
        if (min != i) {
            val temp = array[min]
            array[min] = array[i]
            array[i] = temp
            swapped = true
        }

        // If no swap happened, array is already sorted
        if (!swapped) break
    }
}

fun main() {
    val array = intArrayOf(4, 2, 6, 3, 9, 6, 0)
    selectionSort(array)
    print(array.joinToString())
}