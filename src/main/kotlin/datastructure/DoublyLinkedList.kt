package datastructure

data class DoublyLinkedNode<T>(
    val value: T,
    var prev: DoublyLinkedNode<T>? = null,
    var next: DoublyLinkedNode<T>? = null
)

class DoublyLinkedList<T> {
    private var head: DoublyLinkedNode<T>? = null
    private var tail: DoublyLinkedNode<T>? = null
    private var size = 0

    fun insertAtBeginning(value: T) {
        val newNode = DoublyLinkedNode(value, null, head)
        if (head == null) {
            tail = newNode
        } else {
            head?.prev = newNode
        }
        head = newNode
        size++
    }

    fun displayForward() {
        var temp = head
        while (temp != null) {
            print("${temp.value} ⇄ ")
            temp = temp.next
        }
        println("null")
    }
}

fun main() {
    val doublyList = DoublyLinkedList<Int>()
    doublyList.insertAtBeginning(10)
    doublyList.insertAtBeginning(20)
    doublyList.insertAtBeginning(30)
    doublyList.displayForward()

}