package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException

class QueueWithArrayImpl<E>(size: Int) : Queue<E> {

    private val elements: Array<E> = arrayOfNulls<Any>(size) as Array<E>
    private var nextPos: Int = 0

    override fun head(): E {
        when {
            isEmpty() -> throw QueueUnderFlowException()
            else -> return elements[0]
        }
    }

    override fun dequeue(): E {
        if (isEmpty()) {
            throw QueueUnderFlowException()
        }
        val element = elements[0]
        shiftLeft()
        nextPos--
        return element
    }

    override fun isEmpty(): Boolean {
        return nextPos == 0
    }

    override fun isFull(): Boolean {
        return nextPos == elements.size
    }

    override fun enqueue(element: E) {
        when {
            isFull() -> throw QueueOverFlowException()
            else -> elements[nextPos++] = element
        }
    }

    private fun shiftLeft() {
        for (i in 0 until elements.size-1) {
            elements[i] = elements[i+1]
        }
    }

}