package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException
import java.util.LinkedList

class QueueWithLinkedListImpl<E>(private val size: Int) : Queue<E> {

    private val elements: LinkedList<E> = LinkedList<E>()

    override fun head(): E {
        when {
            isEmpty() -> throw QueueUnderFlowException()
            else -> return elements.first
        }
    }

    override fun dequeue(): E {
        when {
            isEmpty() -> throw QueueUnderFlowException()
            else -> return elements.removeFirst()
        }
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun isFull(): Boolean {
        return elements.size == size
    }

    override fun enqueue(element: E) {
        when {
            isFull() -> throw QueueOverFlowException()
            else -> elements.addLast(element)
        }
    }

}