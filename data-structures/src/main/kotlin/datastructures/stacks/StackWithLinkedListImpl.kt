package datastructures.stacks

import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException
import java.util.*

class StackWithLinkedListImpl<E>(private val size: Int) : Stack<E> {

    private val elements: LinkedList<E> = LinkedList()

    override fun top(): E {
        if (isEmpty()) {
            throw StackUnderFlowException("Stack is empty")
        }
        return elements.first
    }

    override fun pop(): E {
        if (isEmpty()) {
            throw StackUnderFlowException("Stack is empty")
        }
        return elements.removeFirst()
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun isFull(): Boolean {
        return elements.size == size
    }

    override fun push(element: E) {
        if (isFull()) {
            throw StackOverFlowException("Stack is full")
        } else if (element != null) {
            elements.addFirst(element)
        }
    }

}