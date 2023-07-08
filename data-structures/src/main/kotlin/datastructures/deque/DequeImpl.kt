package datastructures.deque

import datastructures.deque.exceptions.DequeOverFlowException
import datastructures.deque.exceptions.DequeUnderFlowException
import java.util.*

class DequeImpl<E>(private val size: Int) : Deque<E> {

    private var elements: LinkedList<E> = LinkedList<E>()

    override fun pushFront(element: E) {
        when {
            isFull() -> throw DequeOverFlowException("Deque is full")
            else -> elements.addFirst(element)
        }
    }

    override fun pushBack(element: E) {
        when {
            isFull() -> throw DequeOverFlowException("Deque is full")
            else -> elements.addLast(element)
        }
    }

    override fun popFront(): E {
        when {
            isEmpty() -> throw DequeUnderFlowException("Deque is empty")
            else -> return elements.removeFirst()
        }
    }

    override fun popBack(): E {
        when {
            isEmpty() -> throw DequeUnderFlowException("Deque is empty")
            else -> return elements.removeLast()
        }
    }

    override fun front(): E {
        when {
            isEmpty() -> throw DequeUnderFlowException("Deque is empty")
            else -> return elements.first
        }
    }

    override fun back(): E {
        when {
            isEmpty() -> throw DequeUnderFlowException("Deque is empty")
            else -> return elements.last
        }
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