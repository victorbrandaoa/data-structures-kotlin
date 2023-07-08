package datastructures.deque

import datastructures.deque.exceptions.DequeOverFlowException
import datastructures.deque.exceptions.DequeUnderFlowException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DequeTest {

    private lateinit var deque: Deque<Int>

    @BeforeEach
    fun setUp() {
        deque = DequeImpl(5)
    }

    @Test
    fun pushFrontIntoFullDeque() {
        deque.pushFront(1)
        deque.pushFront(2)
        deque.pushFront(3)
        deque.pushFront(4)
        deque.pushFront(5)
        assertThrows(DequeOverFlowException::class.java) {
            deque.pushFront(6)
        }
    }

    @Test
    fun frontAfterPushFront() {
        deque.pushFront(1)
        assertEquals(1, deque.front())
        deque.pushFront(2)
        assertEquals(2, deque.front())
    }

    @Test
    fun frontAfterPushBack() {
        deque.pushFront(1)
        assertEquals(1, deque.front())
        deque.pushBack(2)
        assertEquals(1, deque.front())
    }

    @Test
    fun backAfterPushFront() {
        deque.pushFront(1)
        assertEquals(1, deque.back())
        deque.pushFront(2)
        assertEquals(1, deque.back())
    }

    @Test
    fun backAfterPushBack() {
        deque.pushBack(1)
        assertEquals(1, deque.back())
        deque.pushBack(2)
        assertEquals(2, deque.back())
    }

    @Test
    fun frontAfterPopBack() {
        deque.pushFront(1)
        deque.pushFront(2)
        assertEquals(2, deque.front())
        deque.popBack()
        assertEquals(2, deque.front())
    }

    @Test
    fun backAfterPopFront() {
        deque.pushFront(1)
        deque.pushFront(2)
        assertEquals(1, deque.back())
        deque.popFront()
        assertEquals(1, deque.back())
    }

    @Test
    fun backAfterPopBack() {
        deque.pushBack(1)
        deque.pushBack(2)
        assertEquals(2, deque.back())
        deque.popBack()
        assertEquals(1, deque.back())
    }

    @Test
    fun popBackFromNonEmptyDeque() {
        deque.pushFront(1)
        assertEquals(1, deque.popBack())
    }

    @Test
    fun frontFromEmptyDeque() {
        assertThrows(DequeUnderFlowException::class.java) {
            deque.front()
        }
    }

    @Test
    fun popFrontFromEmptyDeque() {
        assertThrows(DequeUnderFlowException::class.java) {
            deque.popFront()
        }
    }

    @Test
    fun dequeIsEmpty() {
        assertTrue(deque.isEmpty())
    }

    @Test
    fun dequeIsNotEmpty() {
        deque.pushBack(1)
        assertFalse(deque.isEmpty())
    }

    @Test
    fun dequeIsFull() {
        deque.pushBack(1)
        deque.pushBack(2)
        deque.pushBack(3)
        deque.pushBack(4)
        deque.pushBack(5)
        assertTrue(deque.isFull())
    }

    @Test
    fun dequeIsNotFull() {
        assertFalse(deque.isFull())
    }

    @Test
    fun isEmptyAfterPopBack() {
        deque.pushBack(1)
        assertFalse(deque.isEmpty())
        deque.popBack()
        assertTrue(deque.isEmpty())
    }

    @Test
    fun isEmptyAfterPopFront() {
        deque.pushBack(1)
        assertFalse(deque.isEmpty())
        deque.popFront()
        assertTrue(deque.isEmpty())
    }

    @Test
    fun isFullAfterPopFront() {
        deque.pushBack(1)
        deque.pushBack(2)
        deque.pushBack(3)
        deque.pushBack(4)
        deque.pushBack(5)
        assertTrue(deque.isFull())
        deque.popFront()
        assertFalse(deque.isFull())
    }

    @Test
    fun pushBackIntoFullDeque() {
        deque.pushBack(1)
        deque.pushBack(2)
        deque.pushBack(3)
        deque.pushBack(4)
        deque.pushBack(5)
        assertThrows(DequeOverFlowException::class.java) {
            deque.pushBack(6)
        }
    }

    @Test
    fun frontFromNonEmptyDeque() {
        deque.pushBack(1)
        assertEquals(1, deque.front())
    }

    @Test
    fun frontAfterPopFront() {
        deque.pushBack(1)
        deque.pushBack(2)
        deque.popFront()
        assertEquals(2, deque.front())
    }

    @Test
    fun popFrontFromNonEmptyDeque() {
        deque.pushBack(1)
        assertEquals(1, deque.popFront())
    }

    @Test
    fun backFromEmptyDeque() {
        assertThrows(DequeUnderFlowException::class.java) {
            deque.back()
        }
    }


    @Test
    fun popBackFromEmptyDeque() {
        assertThrows(DequeUnderFlowException::class.java) {
            deque.popBack()
        }
    }

    @Test
    fun backFromNonEmptyDeque() {
        deque.pushBack(1)
        deque.pushBack(2)
        assertEquals(2, deque.back())
    }

    @Test
    fun clearDeque() {
        deque.pushFront(1)
        deque.pushFront(2)
        deque.pushFront(2)
        assertFalse(deque.isEmpty())
        deque.clear()
        assertTrue(deque.isEmpty())
    }
}