package datastructures.stacks

import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StackWithArrayTest {

    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setUp() {
        stack = StackWithArrayImpl(5)
    }

    @Test
    fun topFromEmptyStack() {
        assertThrows(StackUnderFlowException::class.java) {
            stack.top()
        }
    }

    @Test
    fun popFromEmptyStack() {
        assertThrows(StackUnderFlowException::class.java) {
            stack.pop()
        }
    }

    @Test
    fun stackIsEmpty() {
        assertTrue(stack.isEmpty())
    }

    @Test
    fun stackIsNotEmpty() {
        stack.push(1)
        assertFalse(stack.isEmpty())
    }

    @Test
    fun stackIsNotFull() {
        assertFalse(stack.isFull())
    }

    @Test
    fun stackIsFull() {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        assertTrue(stack.isFull())
    }

    @Test
    fun pushIntoFullStack() {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        assertThrows(StackOverFlowException::class.java) {
            stack.push(6)
        }
    }

    @Test
    fun topFromNonEmptyStack() {
        stack.push(1)
        assertEquals(1, stack.top())
    }

    @Test
    fun topAfterPop() {
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.top())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.top())
    }

    @Test
    fun topAfterPush() {
        stack.push(1)
        assertEquals(1, stack.top())
        stack.push(2)
        assertEquals(2, stack.top())
    }

    @Test
    fun popFromNonEmptyStack() {
        stack.push(1)
        assertEquals(1, stack.pop())
    }

    @Test
    fun isEmptyAfterPop() {
        stack.push(1)
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun isFullAfterPop() {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        assertTrue(stack.isFull())
        stack.pop()
        assertFalse(stack.isFull())
    }
}