package datastructures.deque

import datastructures.deque.exceptions.DequeOverFlowException
import datastructures.deque.exceptions.DequeUnderFlowException
import java.util.*

class DequeImpl<E>(private val size: Int) : Deque<E> {

    private var elements: LinkedList<E> = LinkedList<E>()

    override fun pushFront(element: E) {
        if (isFull()) {
            throw DequeOverFlowException("Deque is full")
        }
        elements.addFirst(element)
    }

    override fun pushBack(element: E) {
        if (isFull()) {
            throw DequeOverFlowException("Deque is full")
        }
        elements.addLast(element)
    }

    override fun popFront(): E {
        if (isEmpty()) {
            throw DequeUnderFlowException("Deque is empty")
        }
        return elements.removeFirst()
    }

    override fun popBack(): E {
        if (isEmpty()) {
            throw DequeUnderFlowException("Deque is empty")
        }
        return elements.removeLast()
    }

    override fun front(): E {
        if (isEmpty()) {
            throw DequeUnderFlowException("Deque is empty")
        }
        return elements.first
    }

    override fun back(): E {
        if (isEmpty()) {
            throw DequeUnderFlowException("Deque is empty")
        }
        return elements.last
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun isFull(): Boolean {
        return elements.size == size
    }

    override fun clear() {
        elements = LinkedList<E>()
    }
}