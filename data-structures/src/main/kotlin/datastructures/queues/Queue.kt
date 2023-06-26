package datastructures.queues

interface Queue<E> {

    fun head(): E

    fun enqueue(element: E)

    fun dequeue(): E

    fun isEmpty(): Boolean

    fun isFull(): Boolean

}