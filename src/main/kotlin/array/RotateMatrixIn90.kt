package array

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    transposeInPlace(matrix)
    reverseRow(matrix)
    for (row in matrix) {
        println(row.joinToString())
    }
}

fun reverseRow(matrix: Array<IntArray>) {
    val row = matrix.size
    for (row in 0 until row) {
        var start = 0
        var end = matrix[row].size - 1
        while (start < end) {
            val temp = matrix[row][start]
            matrix[row][start] = matrix[row][end]
            matrix[row][end] = temp
            start++
            end--
        }
    }
}

fun transposeInPlace(matrix: Array<IntArray>) {
    val r = matrix.size
    val c = matrix[0].size

    for (row in 0 until r) {
        for (col in row + 1 until c) {
            val temp = matrix[row][col]
            matrix[row][col] = matrix[col][row]
            matrix[col][row] = temp
        }
    }
}
