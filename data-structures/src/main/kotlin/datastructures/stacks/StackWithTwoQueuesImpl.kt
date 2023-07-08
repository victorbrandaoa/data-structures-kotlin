package datastructures.stacks

import datastructures.queues.Queue
import datastructures.queues.QueueWithLinkedListImpl
import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException

class StackWithTwoQueuesImpl<E>(size: Int) : Stack<E> {

    private var primaryQueue: Queue<E> = QueueWithLinkedListImpl(size)
    private var auxiliarQueue: Queue<E> = QueueWithLinkedListImpl(size)

    override fun top(): E {
        if (isEmpty()) {
            throw StackUnderFlowException("stack is empty")
        }

        return primaryQueue.head()
    }

    override fun pop(): E {
        if (isEmpty()) {
            throw StackUnderFlowException("stack is empty")
        }

        return primaryQueue.dequeue()
    }

    override fun isEmpty(): Boolean {
        return primaryQueue.isEmpty()
    }

    override fun isFull(): Boolean {
        return primaryQueue.isFull()
    }

    override fun push(element: E) {
        if (isFull()) {
            throw StackOverFlowException("stack is full")
        }
        auxiliarQueue.enqueue(element)
        while(!primaryQueue.isEmpty()) {
            auxiliarQueue.enqueue(primaryQueue.dequeue())
        }
        swapQueues()
    }

    private fun swapQueues() {
        val temp = primaryQueue
        primaryQueue = auxiliarQueue
        auxiliarQueue = temp
    }
}