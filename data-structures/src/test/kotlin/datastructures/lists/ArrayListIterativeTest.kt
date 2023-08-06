package datastructures.lists

import datastructures.lists.arraylist.ArrayListIterativeImpl
import datastructures.lists.arraylist.exceptions.ArrayIndexOutOfBoundsException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArrayListIterativeTest {

    private lateinit var list: List<Int>

    @BeforeEach
    fun setUp() {
        list = ArrayListIterativeImpl(5)
    }

    @Test
    fun testAddLastToEmptyList() {
        list.addLast(5)
        assertEquals(5, list.getLast())
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testAddLastToNonEmptyList() {
        list.addLast(5)
        list.addLast(6)
        assertEquals(6, list.getLast())
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testAddLastToFullList() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.addLast(4)
        list.addLast(5)
        list.addLast(6)
        assertEquals(6, list.getLast())
        assertEquals(1, list.getFirst())
    }

    @Test
    fun testAddLastRepeatedElement() {
        list.addLast(1)
        list.addLast(1)
        assertEquals(1, list.getLast())
        assertEquals(1, list.getFirst())
    }

    @Test
    fun testAddFirstToEmptyList() {
        list.addFirst(5)
        assertEquals(5, list.getFirst())
        assertEquals(5, list.getLast())
    }

    @Test
    fun testAddFirstToNonEmptyList() {
        list.addFirst(5)
        list.addFirst(6)
        assertEquals(6, list.getFirst())
        assertEquals(5, list.getLast())
    }

    @Test
    fun testAddFirstToFullList() {
        list.addFirst(1)
        list.addFirst(2)
        list.addFirst(3)
        list.addFirst(4)
        list.addFirst(5)
        list.addFirst(6)
        assertEquals(6, list.getFirst())
        assertEquals(1, list.getLast())
    }

    @Test
    fun testAddFirstRepeatedElement() {
        list.addFirst(1)
        list.addFirst(1)
        assertEquals(1, list.getFirst())
        assertEquals(1, list.getLast())
    }

    @Test
    fun testAddAtIndexOutOfBoundsLowerThanZero() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.addAtIndex(-1, 5)
        }
    }

    @Test
    fun testAddAtIndexEmptyList() {
        list.addAtIndex(3, 5)
        assertNull(list.getLast())
        assertNull(list.getFirst())
        assertEquals(5, list.get(3))
    }

    @Test
    fun testAddAtIndexFullList() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.addLast(4)
        list.addLast(5)
        list.addLast(6)
        list.addAtIndex(3, 5)
        assertEquals(5, list.get(3))
        assertEquals(4, list.get(4))
        assertEquals(6, list.getLast())
        assertEquals(1, list.getFirst())
    }
}