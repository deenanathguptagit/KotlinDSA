package graph

import java.util.*
import kotlin.collections.ArrayDeque

class Solution1 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val curColor = image[sr][sc]
        //Using DFS
        //dfs(image, sr, sc, color, curColor)

        //using BFS
        val rows = image.size
        val cols = image[0].size

        val deque = ArrayDeque<IntArray>()
        deque.add(intArrayOf(sr, sc))

        while (deque.isNotEmpty()) {
            val node = deque.removeFirst()
            val r = node[0]
            val c = node[1]
            val ajcList =
                arrayOf(intArrayOf(r + 1, c), intArrayOf(r - 1, c), intArrayOf(r, c + 1), intArrayOf(r, c - 1))
            for ((row, col) in ajcList) {
                if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] == color || image[row][col] != curColor) {
                    continue
                }
                image[row][col] = color
                deque.add(intArrayOf(row, col))
            }
        }
        return image
    }

    fun dfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int, curColor: Int) {
        if (sr < 0 || sr >= image.size || sc < 0 || sc >= image[0].size
            || image[sr][sc] == color || image[sr][sc] != curColor
        ) {
            return
        }
        image[sr][sc] = color
        dfs(image, sr + 1, sc, color, curColor)
        dfs(image, sr - 1, sc, color, curColor)
        dfs(image, sr, sc + 1, color, curColor)
        dfs(image, sr, sc - 1, color, curColor)
    }

    fun dfs1(image: Array<IntArray>, sr: Int, sc: Int, color: Int, curColor: Int) {
        if (sr < 0 || sr >= image.size || sc < 0 || sc >= image[0].size
            || image[sr][sc] == color || image[sr][sc] != curColor
        ) {
            return
        }
        image[sr][sc] = color
        val ajcList =
            arrayOf(intArrayOf(sr + 1, sc), intArrayOf(sr - 1, sc), intArrayOf(sr, sc + 1), intArrayOf(sr, sc - 1))
        for ((row, col) in ajcList) {
            dfs(image, row, col, color, curColor)
        }
    }
}