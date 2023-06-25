package datastructures.stacks

import datastructures.stacks.exceptions.StackOverFlowException
import datastructures.stacks.exceptions.StackUnderFlowException
import org.junit.jupiter.api.Assertions
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
        Assertions.assertThrows(StackUnderFlowException::class.java) {
            stack.top()
        }
    }

    @Test
    fun popFromEmptyStack() {
        Assertions.assertThrows(StackUnderFlowException::class.java) {
            stack.pop()
        }
    }

    @Test
    fun stackIsEmpty() {
        Assertions.assertTrue(stack.isEmpty())
    }

    @Test
    fun stackIsNotEmpty() {
        stack.push(1)
        Assertions.assertFalse(stack.isEmpty())
    }

    @Test
    fun stackIsNotFull() {
        Assertions.assertFalse(stack.isFull())
    }

    @Test
    fun stackIsFull() {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        Assertions.assertTrue(stack.isFull())
    }

    @Test
    fun pushIntoFullStack() {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        Assertions.assertThrows(StackOverFlowException::class.java) {
            stack.push(6)
        }
    }

    @Test
    fun topFromNonEmptyStack() {
        stack.push(1)
        Assertions.assertEquals(1, stack.top())
    }

    @Test
    fun topAfterPop() {
        stack.push(1)
        stack.push(2)
        Assertions.assertEquals(2, stack.pop())
        Assertions.assertEquals(1, stack.top())
    }

    @Test
    fun popFromNonEmptyStack() {
        stack.push(1)
        Assertions.assertEquals(1, stack.pop())
    }
}