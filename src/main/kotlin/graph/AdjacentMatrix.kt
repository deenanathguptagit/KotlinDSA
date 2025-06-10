package graph

class Graph(val nodes: Int) {
    private val adjMatrix: Array<IntArray> = Array(nodes) { IntArray(nodes) }

    fun addEdgesInMatrix(edges: Array<IntArray>, isDirectedGraph: Boolean) {
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            if (isDirectedGraph) {
                adjMatrix[u][v] = 1
            } else {
                adjMatrix[u][v] = 1
                adjMatrix[v][u] = 1
            }
        }
    }

    fun printEdgesInMatrix() {
        for (i in adjMatrix.indices) {
            print("$i -> ")
            for (j in adjMatrix[0].indices) {
                print("${adjMatrix[i][j]} ")
            }
            println()
        }
    }
}

fun main() {
    println("UnDirected Graph")
    val graph = Graph(4)
    val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3))
    graph.addEdgesInMatrix(edges, false)
    graph.printEdgesInMatrix()
    println("Directed Graph")
    val graph1 = Graph(4)
    val edges1 = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
    graph1.addEdgesInMatrix(edges1, true)
    graph1.printEdgesInMatrix()
}