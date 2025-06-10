package graph

fun main() {
    val obj = Solution()
    val res = obj.dfsOfGraph(5, arrayOf(intArrayOf(2, 3, 1), intArrayOf(0), intArrayOf(0, 4), intArrayOf(0), intArrayOf(2)))
    println(res.joinToString(","))
}
class Solution {
    fun dfsOfGraph(v: Int, adj: Array<IntArray>): ArrayList<Int> {
        val result = ArrayList<Int>()
        val visited = BooleanArray(v) { false }

        dfs(0, adj, visited, result)
        return result
    }

    private fun dfs(v: Int, adj: Array<IntArray>, visited: BooleanArray, result: ArrayList<Int>) {
        visited[v] = true
        result.add(v)

        for (neighbor in adj[v]) {
            if (visited[neighbor].not()) {
                dfs(neighbor, adj, visited, result)
            }
        }
    }
}