import java.lang.Exception

data class Node<T>(var data: T, var next: Node<T>? = null)

class SinglyLinkedList<T> {
    private var head: Node<T>? = null
    private var size = 0
    fun insertInBeginning(value: T) {
        val newNode = Node(value, head)
        if (head == null) {
            size++
            head = newNode
            return
        }
        newNode.next = head
        head = newNode
        size++
    }

    fun insertAtPosition(value: T, position: Int) {
        if (position < 0 || position > size) {
            throw Exception("Invalid Position")
        }
        if (position == 0) {
            insertInBeginning(value)
            return
        }

        val newNode = Node(value)
        var temp = head
        for (i in 0..<position - 1) {
            temp = temp?.next
        }
        newNode.next = temp?.next
        temp?.next = newNode
        size++
    }

    // Delete at a specific position
    fun deleteAtPosition(position: Int) {
        if (position == 0) {
            head = head?.next
            size--
            return
        }
        var temp = head
        for (i in 0..<position - 1) {
            temp = temp?.next
        }
        println("Deleted ${temp?.next?.data}")
        temp?.next = temp?.next?.next
        size--
    }

    fun insertAtEnd(value: T) {
        if (head == null) {
            size++
            head = Node(value, head)
            return
        }

        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        size++
        temp?.next = Node(value)
    }

    fun display() {
        var temp = head
        while (temp != null) {
            println(temp.data)
            temp = temp.next
        }
    }

    fun getSize() = size
}

fun main() {
    val list = SinglyLinkedList<Int>()
    list.insertInBeginning(10)
    list.insertInBeginning(11)
    list.insertAtEnd(12)
    list.insertAtEnd(13)
    list.insertAtPosition(111, 2)
    list.deleteAtPosition(1)
    list.display()
    println("=========")
    println(list.getSize())
}