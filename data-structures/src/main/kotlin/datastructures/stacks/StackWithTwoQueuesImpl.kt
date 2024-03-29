package datastructures.stacks

import datastructures.queues.Queue
import datastructures.queues.QueueWithLinkedListImpl
import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException

class StackWithTwoQueuesImpl<E>(size: Int) : Stack<E> {

    private var primaryQueue: Queue<E> = QueueWithLinkedListImpl(size)
    private var auxiliarQueue: Queue<E> = QueueWithLinkedListImpl(size)

    override fun top(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return primaryQueue.head()
        }
    }

    override fun pop(): E {
        when {
            isEmpty() -> throw StackUnderFlowException()
            else -> return primaryQueue.dequeue()
        }
    }

    override fun isEmpty(): Boolean {
        return primaryQueue.isEmpty()
    }

    override fun isFull(): Boolean {
        return primaryQueue.isFull()
    }

    override fun push(element: E) {
        if (isFull()) {
            throw StackOverFlowException()
        }
        auxiliarQueue.enqueue(element)
        while(!primaryQueue.isEmpty()) {
            auxiliarQueue.enqueue(primaryQueue.dequeue())
        }
        swapQueues()
    }

    private fun swapQueues() {
        primaryQueue = auxiliarQueue.also { auxiliarQueue = primaryQueue }
    }
}