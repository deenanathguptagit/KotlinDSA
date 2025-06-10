package graph

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(numIslandsUsingDFS(grid))
    println(numIslandsUsingBFS(grid))
}

fun numIslandsUsingBFS(grid: Array<CharArray>): Any {

    return 0
}

fun numIslandsUsingDFS(grid: Array<CharArray>): Int {
    var count = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == '1') {
                dfs(grid, i, j)
                count++
            }
        }
    }
    return count
}

fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || i > grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0') {
        return
    }
    val neighbors = arrayOf(intArrayOf(i + 1, j), intArrayOf(i - 1, j), intArrayOf(i, j + 1), intArrayOf(i, j - 1))
    grid[i][j] = '0'
    for (neighbor in neighbors) {
        val row = neighbor[0]
        val col = neighbor[1]
        dfs(grid, row, col)
    }
//    grid[i][j] = '0'
//    dfs(grid, i + 1, j)
//    dfs(grid, i - 1, j)
//    dfs(grid, i, j + 1)
//    dfs(grid, i, j - 1)

}
