package datastructures.deque

interface Deque<E> {

    fun pushFront(element: E)

    fun pushBack(element: E)

    fun popFront(): E

    fun popBack(): E

    fun front(): E

    fun back(): E

    fun isEmpty(): Boolean

    fun isFull(): Boolean

    fun clear()

}