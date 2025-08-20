package sorting

/**repeatedly swap adjacent elements if they are in the wrong order until the entire list is sorted.*/
fun bubbleSort(array: IntArray) {
    val n = array.size
    for (i in 0 until n - 1) {
        //flag to keep track of swaping, if there is no swapping then we can break the outer loop
        var flag = 0
        for (j in 0 until n - 1 - i) {
            if (array[j] > array[j + 1]) {
                flag = 1
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        //if array is already shorted then no need to continue the outer loop
        if (flag == 0) {
            break
        }
    }
}

fun main() {
    val array = intArrayOf(1, 4, 2, 6, 3, 9, 6, 0)
    bubbleSort(array)
    print(array.joinToString())
}