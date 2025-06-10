package graph

class GraphUsingList(private val nodes: Int) {
    val adjList: List<MutableList<Int>> = MutableList(nodes) { mutableListOf() }

    fun addEdgesInList(edges: Array<IntArray>, isDirectedGraph: Boolean) {
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            if (isDirectedGraph) {
                adjList[u].add(v)
            } else {
                adjList[u].add(v)
                adjList[v].add(u)
            }
        }
    }

    fun findDegreeInDirectedGraph(edges: Array<IntArray>, nodes: Int) {
        val inDegree = IntArray(nodes)
        val outDegree = IntArray(nodes)
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]
            inDegree[to]++
            outDegree[from]++
        }

        for (i in inDegree.indices) {
            print("In-dgree $i -> ${inDegree[i]}\t")
            print("out-degree $i -> ${outDegree[i]}")
            println()
        }
    }

    fun findCenter(edges: Array<IntArray>): Int {
        val degree = IntArray(edges.size + 1)
        for(edge in edges) {
            val u = edge[0]
            val v = edge[1]
            degree[u]++
            degree[v]++
        }

        for(index in degree.indices) {
            if(degree[index] == edges.size) {
                return index + 1
            }
        }
        return 0
    }

    fun findDegreeInUnDirectedGraph(edges: Array<IntArray>, nodes: Int) {
        val degree = IntArray(nodes)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            degree[u]++
            degree[v]++
        }

        for (i in degree.indices) {
            println("$i -> ${degree[i]}\t")
        }
    }

    fun printList() {
        for (row in adjList.indices) {
            print("$row -> [")
            for (column in adjList[row].indices) {
                print("${adjList[row][column]}")
                if (column != adjList[row].size - 1) {
                    print(", ")
                }
            }
            print("]")
            println()
        }
    }
}

fun main() {
    val graph = GraphUsingList(4)
    /*val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3))
    graph.addEdgesInList(edges, false)
    val graph1 = GraphUsingList(4)
    val edges1 = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3))
    graph.addEdgesInList(edges1, true)
//    graph.printList()
    println("Degree In Undirected Graph")
    graph.findDegreeInUnDirectedGraph(edges, 4)
    println("Degree In directed Graph")
    graph1.findDegreeInDirectedGraph(edges, 4)
*/
    val edges = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(4,2))
    graph.findDegreeInUnDirectedGraph(edges, 4)
}