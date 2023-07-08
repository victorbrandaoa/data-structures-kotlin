package datastructures.stacks

import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException

class StackWithArrayImpl<E>(size: Int) : Stack<E> {

    private val elements: Array<E> = arrayOfNulls<Any>(size) as Array<E>
    private var top: Int = -1

    override fun top(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return elements[top]
        }
    }

    override fun pop(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return elements[top--]
        }
    }

    override fun isEmpty(): Boolean {
        return top == -1
    }

    override fun isFull(): Boolean {
        return top == elements.size -1
    }

    override fun push(element: E) {
        when {
            isFull() -> throw StackOverFlowException()
            else -> elements[++top] = element
        }
    }
}