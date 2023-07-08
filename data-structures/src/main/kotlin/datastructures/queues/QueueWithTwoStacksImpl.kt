package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException
import datastructures.stacks.Stack
import datastructures.stacks.StackWithLinkedListImpl

class QueueWithTwoStacksImpl<E>(size: Int) : Queue<E> {

    private var primaryStack: Stack<E> = StackWithLinkedListImpl(size)
    private var auxiliarStack: Stack<E> = StackWithLinkedListImpl(size)

    override fun head(): E {
        when {
            isEmpty() -> throw QueueUnderFlowException()
            else -> return primaryStack.top()
        }
    }

    override fun dequeue(): E {
        when {
            isEmpty() -> throw QueueUnderFlowException()
            else -> return primaryStack.pop()
        }
    }

    override fun isEmpty(): Boolean {
        return primaryStack.isEmpty()
    }

    override fun isFull(): Boolean {
        return primaryStack.isFull()
    }

    override fun enqueue(element: E) {
        if (isFull()) {
            throw QueueOverFlowException()
        }
        auxiliarStack.push(element)
        while(!primaryStack.isEmpty()) {
            auxiliarStack.push(primaryStack.pop())
        }
        swapStacks()
    }

    private fun swapStacks() {
        val temp = primaryStack
        primaryStack = auxiliarStack
        auxiliarStack = temp
    }
}