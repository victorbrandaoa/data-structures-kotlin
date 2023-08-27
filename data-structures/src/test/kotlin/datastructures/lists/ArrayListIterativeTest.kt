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
    fun testAddAtIndexOutOfBoundsGreaterThanSize() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.addAtIndex(5, 5)
        }
    }

    @Test
    fun testAddAtIndexZeroEmptyList() {
        list.addAtIndex(0, 5)
        assertEquals(5, list.getLast())
        assertEquals(5, list.getFirst())
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

    @Test
    fun testSetIndexOutOfBoundsGreaterThanSize() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.set(5, 5)
        }
    }

    @Test
    fun testSetIndexOutOfBoundsLowerThanZero() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.set(-1, 5)
        }
    }

    @Test
    fun testSetInvalidEmptyPosition() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.set(3, 3)
        }
    }

    @Test
    fun testSetValidPosition() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.addLast(4)
        list.addLast(5)
        list.set(3, 9)
        assertEquals(9, list.get(3))
    }

    @Test
    fun testIsEmptyWithEmptyList() {
        assertTrue(list.isEmpty())
    }

    @Test
    fun testIsEmptyWithNonEmptyList() {
        list.addLast(1)
        assertFalse(list.isEmpty())
    }

    @Test
    fun testSizeWithEmptyList() {
        assertEquals(0, list.size())
    }

    @Test
    fun testSizeWithNonEmptyList() {
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        assertEquals(3, list.size())
    }

    @Test
    fun testGetFirstFromEmptyList() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getFirst()
        }
    }

    @Test
    fun testGetLastFromEmptyList() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getLast()
        }
    }

    @Test
    fun testGetIndexOutOfBoundsGreaterThanSize() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.get(5)
        }
    }

    @Test
    fun testGetIndexOutOfBoundsLowerThanZero() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.get(-1)
        }
    }

    @Test
    fun testGetFirstNonEmptyList() {
        list.addLast(5)
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testGetFirstEmptyListAfterRemoveLast() {
        list.addLast(5)
        list.removeLast()
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getFirst()
        }
    }

    @Test
    fun testGetFirstEmptyListAfterRemoveFirst() {
        list.addLast(5)
        list.removeFirst()
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getFirst()
        }
    }

    @Test
    fun testGetFirstNonEmptyListAfterNewAddLast() {
        list.addLast(5)
        list.addLast(6)
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testGetFirstNonEmptyListAfterNewAddFirst() {
        list.addLast(5)
        list.addFirst(6)
        assertEquals(6, list.getFirst())
    }

    @Test
    fun testGetFirstNonEmptyListNewAddLastAfterRemoveFirst() {
        list.addLast(5)
        list.removeFirst()
        list.addLast(6)
        assertEquals(6, list.getFirst())
    }

    @Test
    fun testGetFirstOneElementListNewAddLastAfterRemoveLast() {
        list.addLast(5)
        list.removeLast()
        list.addLast(6)
        assertEquals(6, list.getFirst())
    }

    @Test
    fun testGetFirstTwoElementsListNewAddLastAfterRemoveLast() {
        list.addLast(5)
        list.addLast(6)
        list.removeLast()
        list.addLast(6)
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testGetLastNonEmptyList() {
        list.addLast(5)
        assertEquals(5, list.getLast())
    }

    @Test
    fun testGetLastNonEmptyListAfterRemoveLast() {
        list.addLast(5)
        list.removeLast()
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getLast()
        }
    }

    @Test
    fun testGetLastNonEmptyListAfterRemoveFirst() {
        list.addLast(5)
        list.removeFirst()
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.getLast()
        }
    }

    @Test
    fun testGetLastNonEmptyListAfterNewAddLast() {
        list.addLast(5)
        list.addLast(6)
        assertEquals(6, list.getLast())
    }

    @Test
    fun testGetLastNonEmptyListAfterNewAddFirst() {
        list.addLast(5)
        list.addFirst(6)
        assertEquals(5, list.getLast())
    }

    @Test
    fun testGetLastNonEmptyListNewAddLastAfterRemoveFirst() {
        list.addLast(5)
        list.removeFirst()
        list.addLast(6)
        assertEquals(6, list.getLast())
    }

    @Test
    fun testGetLastOneElementListNewAddLastAfterRemoveFirst() {
        list.addLast(5)
        list.removeFirst()
        list.addLast(6)
        assertEquals(6, list.getLast())
    }

    @Test
    fun testGetLastTwoElementListNewAddLastAfterRemoveLast() {
        list.addLast(5)
        list.addLast(6)
        list.removeLast()
        list.addLast(7)
        assertEquals(7, list.getLast())
    }

    @Test
    fun testIndexOfElementNotInList() {
        list.addLast(5)
        assertEquals(-1, list.indexOf(4))
    }

    @Test
    fun testIndexOfEmptyList() {
        assertEquals(-1, list.indexOf(4))
    }

    @Test
    fun testIndexOfElementInList() {
        list.addLast(5)
        assertEquals(0, list.indexOf(5))
    }

    @Test
    fun testContainsElementInList() {
        list.addLast(5)
        assertTrue(list.contains(5))
    }

    @Test
    fun testContainsElementNotInList() {
        list.addLast(5)
        assertFalse(list.contains(4))
    }

    @Test
    fun testContainsEmptyList() {
        assertFalse(list.contains(4))
    }

    @Test
    fun testToArrayEmptyList() {
        assertTrue(arrayOfNulls<Int>(0).contentEquals(list.toArray()))
    }

    @Test
    fun testToArrayNonEmptyList() {
        val expectedArray = arrayOf(1, 2, 3)
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        assertTrue(expectedArray.contentEquals(list.toArray()))
    }

    @Test
    fun testToArrayNonEmptyListAfterRemoveFirst() {
        val expectedArray = arrayOf(2, 3)
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.removeFirst()
        assertTrue(expectedArray.contentEquals(list.toArray()))
    }

    @Test
    fun testToArrayNonEmptyListAfterRemoveLast() {
        val expectedArray = arrayOf(1, 2)
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.removeLast()
        assertTrue(expectedArray.contentEquals(list.toArray()))
    }

    @Test
    fun testToArrayNonEmptyListAfterRemoveByIndex() {
        val expectedArray = arrayOf(1, 3)
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.removeByIndex(1)
        assertTrue(expectedArray.contentEquals(list.toArray()))
    }

    @Test
    fun testToArrayNonEmptyListAfterRemoveByElement() {
        val expectedArray = arrayOf(1, 3)
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.removeByElement(2)
        assertTrue(expectedArray.contentEquals(list.toArray()))
    }

    @Test
    fun testRemoveFirstEmptyList() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.removeFirst()
        }
    }

    @Test
    fun testRemoveLastEmptyList() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.removeLast()
        }
    }

    @Test
    fun testRemoveByIndexEmptyList() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.removeByIndex(2)
        }
    }

    @Test
    fun testRemoveByElementEmptyList() {
        assertNull(list.removeByElement(5))
    }

    @Test
    fun testRemoveFirstNonEmptyList() {
        list.addLast(5)
        assertEquals(5, list.removeFirst())
        assertEquals(0, list.size())
    }

    @Test
    fun testRemoveFirstNonEmptyListAfterAddFirst() {
        list.addLast(5)
        list.addFirst(3)
        assertEquals(3, list.removeFirst())
        assertEquals(5, list.getFirst())
    }

    @Test
    fun testRemoveFirstNonEmptyListAfterAddLast() {
        list.addLast(5)
        list.addLast(3)
        assertEquals(5, list.removeFirst())
        assertEquals(3, list.getFirst())
    }

    @Test
    fun testRemoveLastNonEmptyList() {
        list.addLast(5)
        assertEquals(5, list.removeLast())
        assertEquals(0, list.size())
    }

    @Test
    fun testRemoveLastNonEmptyListAfterAddFirst() {
        list.addLast(5)
        list.addFirst(3)
        assertEquals(5, list.removeLast())
        assertEquals(3, list.getFirst())
    }

    @Test
    fun testRemoveLastNonEmptyListAfterAddLast() {
        list.addLast(5)
        list.addLast(3)
        assertEquals(3, list.removeLast())
        assertEquals(5, list.getLast())
    }

    @Test
    fun testRemoveByIndexNonEmptyListValidPosition() {
        list.addLast(5)
        list.addLast(6)
        assertEquals(6, list.removeByIndex(1))
        assertEquals(5, list.getLast())
    }

    @Test
    fun testRemoveByIndexNonEmptyListInvalidPosition() {
        list.addLast(5)
        list.addLast(6)
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.removeByIndex(2)
        }
    }

    @Test
    fun testRemoveByElementNonEmptyList() {
        list.addLast(5)
        list.addLast(6)
        assertEquals(6, list.removeByElement(6))
        assertEquals(5, list.getLast())
    }

    @Test
    fun testRemoveByElementNonEmptyListElementNotInList() {
        list.addLast(5)
        list.addLast(6)
        assertNull(list.removeByElement(4))
        assertEquals(2, list.size())
    }
}