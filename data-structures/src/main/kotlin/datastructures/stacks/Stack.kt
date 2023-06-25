package datastructures.stacks

interface Stack<E> {

    fun top(): E

    fun pop(): E

    fun push(element: E)

    fun isEmpty(): Boolean

    fun isFull(): Boolean

}