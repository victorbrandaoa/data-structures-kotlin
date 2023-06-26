package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException

class QueueWithArrayCircularImpl<E>(size: Int) : Queue<E> {

    private val elements: Array<E> = arrayOfNulls<Any>(size) as Array<E>
    private var head: Int = -1
    private var tail: Int = -1

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

        if (head == tail) {
            head = -1
            tail = -1
        } else {
            head = (head+1) % elements.size
        }
        return element
    }

    override fun isEmpty(): Boolean {
        return head == -1 && tail == -1
    }

    override fun isFull(): Boolean {
        return (tail+1) % elements.size == head
    }

    override fun enqueue(element: E) {
        if (isFull()) {
            throw QueueOverFlowException("Queue is full")
        }
        if (isEmpty()) {
            head = 0
            tail = 0
        } else {
            tail = (tail+1) % elements.size
        }
        elements[tail] = element
    }
}