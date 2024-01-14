package algorithms.sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BubbleSortTest {

    @Test
    fun testBubbleSort() {
        val array = intArrayOf(5, 3, 1, 4, 2)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testBubbleSortAlreadySortedArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testBubbleSortDescendingSortedArray() {
        val array = intArrayOf(9, 7, 5, 3, 1)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(1, 3, 5, 7, 9), array)
    }

    @Test
    fun testBubbleSortDuplicatedElements() {
        val array = intArrayOf(4, 2, 4, 1, 3, 2)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 4, 4), array)
    }

    @Test
    fun testBubbleSortEmptyArray() {
        val array = intArrayOf()
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(), array)
    }

    @Test
    fun testBubbleSortSingleElementArray() {
        val array = intArrayOf(42)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(42), array)
    }

    @Test
    fun testBubbleSortNegativeElements() {
        val array = intArrayOf(-5, -3, -1, -4, -2)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(-5, -4, -3, -2, -1), array)
    }

    @Test
    fun testBubbleSortAllElementsEqual() {
        val array = intArrayOf(7, 7, 7, 7, 7)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(7, 7, 7, 7, 7), array)
    }

    @Test
    fun testBubbleSortMixedWithPositiveNegativeElements() {
        val array = intArrayOf(-2, 5, 0, -7, 3)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(-7, -2, 0, 3, 5), array)
    }

    @Test
    fun testBubbleSortLargerArray() {
        val array = intArrayOf(10, 8, 15, 22, 5, 17, 13, 19)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(5, 8, 10, 13, 15, 17, 19, 22), array)
    }

    @Test
    fun testBubbleSortLargerArrayWithNegativeElements() {
        val array = intArrayOf(-10, -8, -15, 0, 50, 300, -22, -5, -17, -13, -19)
        BubbleSort.sort(array)
        assertArrayEquals(intArrayOf(-22, -19, -17, -15, -13, -10, -8, -5, 0, 50, 300), array)
    }
}