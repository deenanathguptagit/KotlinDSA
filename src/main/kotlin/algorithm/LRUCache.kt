package algorithm

class LRUCache1(private val capacity: Int) {
    private data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0) // dummy head
    private val tail = Node(0, 0) // dummy tail

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
        } else {
            if (map.size == capacity) {
                // Remove least recently used
                val lru = tail.prev!!
                removeNode(lru)
                map.remove(lru.key)
            }
            val newNode = Node(key, value)
            addNode(newNode)
            map[key] = newNode
        }
    }

    private fun addNode(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addNode(node)
    }
}

class LRUCache(capacity: Int) {
    private val map = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: Int): Int {
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        map[key] = value
    }
}

