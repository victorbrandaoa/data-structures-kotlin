package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException

class QueueWithArrayCircularImpl<E>(size: Int) : Queue<E> {

    private val elements: Array<E> = arrayOfNulls<Any>(size) as Array<E>
    private var head: Int = -1
    private var tail: Int = -1
    private var currentSize: Int = 0

    override fun head(): E {
        if (isEmpty()) {
            throw QueueUnderFlowException("Queue is empty")
        }
        return elements[head]
    }

    override fun dequeue(): E {
        if(isEmpty()) {
            throw QueueUnderFlowException("Queue is empty")
        }
        val element: E = elements[head]
        head = (head+1) % elements.size
        currentSize--
        return element
    }

    override fun isEmpty(): Boolean {
        return currentSize == 0
    }

    override fun isFull(): Boolean {
        return currentSize == elements.size
    }

    override fun enqueue(element: E) {
        if (isFull()) {
            throw QueueOverFlowException("Queue is full")
        }
        if (isEmpty()) {
            head = (head+1) % elements.size
        }
        tail = (tail+1) % elements.size
        elements[tail] = element
        currentSize++
    }
}