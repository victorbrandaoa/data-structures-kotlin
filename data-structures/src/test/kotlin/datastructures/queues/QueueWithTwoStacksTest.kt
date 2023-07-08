package datastructures.queues

import datastructures.queues.exceptions.QueueOverFlowException
import datastructures.queues.exceptions.QueueUnderFlowException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class QueueWithTwoStacksTest {

    private lateinit var queue: Queue<Int>

    @BeforeEach
    fun setUp() {
        queue = QueueWithTwoStacksImpl(5)
    }

    @Test
    fun headFromEmptyQueue() {
        assertThrows(QueueUnderFlowException::class.java) {
            queue.head()
        }
    }

    @Test
    fun dequeueFromEmptyQueue() {
        assertThrows(QueueUnderFlowException::class.java) {
            queue.dequeue()
        }
    }

    @Test
    fun queueIsEmpty() {
        assertTrue(queue.isEmpty())
    }

    @Test
    fun queueIsNotEmpty() {
        queue.enqueue(1)
        assertFalse(queue.isEmpty())
    }

    @Test
    fun queueIsFull() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)
        assertTrue(queue.isFull())
    }

    @Test
    fun queueIsNotFull() {
        assertFalse(queue.isFull())
    }

    @Test
    fun isEmptyAfterDequeue() {
        queue.enqueue(1)
        assertFalse(queue.isEmpty())
        queue.dequeue()
        assertTrue(queue.isEmpty())
    }

    @Test
    fun isFullAfterDequeue() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)
        assertTrue(queue.isFull())
        queue.dequeue()
        assertFalse(queue.isFull())
    }

    @Test
    fun enqueueIntoFullQueue() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)
        assertThrows(QueueOverFlowException::class.java) {
            queue.enqueue(6)
        }
    }

    @Test
    fun headFromNonEmptyQueue() {
        queue.enqueue(1)
        assertEquals(1, queue.head())
    }

    @Test
    fun headAfterDequeue() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.dequeue()
        assertEquals(2, queue.head())
    }

    @Test
    fun dequeueFromNonEmptyQueue() {
        queue.enqueue(1)
        assertEquals(1, queue.dequeue())
    }
}