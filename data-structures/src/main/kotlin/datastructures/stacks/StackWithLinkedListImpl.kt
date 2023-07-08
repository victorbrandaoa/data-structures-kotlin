package datastructures.stacks

import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException
import java.util.*

class StackWithLinkedListImpl<E>(private val size: Int) : Stack<E> {

    private val elements: LinkedList<E> = LinkedList()

    override fun top(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return elements.first
        }
    }

    override fun pop(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return elements.removeFirst()
        }
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun isFull(): Boolean {
        return elements.size == size
    }

    override fun push(element: E) {
        when {
            isFull() -> throw StackOverFlowException()
            else -> elements.addFirst(element)
        }
    }

}