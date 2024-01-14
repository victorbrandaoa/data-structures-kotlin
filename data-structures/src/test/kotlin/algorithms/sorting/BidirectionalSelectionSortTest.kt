package algorithms.sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BidirectionalBidirectionalSelectionSortTest {

    @Test
    fun testBidirectionalSelectionSort() {
        val array = intArrayOf(5, 3, 1, 4, 2)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testBidirectionalSelectionSortAlreadySortedArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testBidirectionalSelectionSortDescendingSortedArray() {
        val array = intArrayOf(9, 7, 5, 3, 1)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 3, 5, 7, 9), array)
    }

    @Test
    fun testBidirectionalSelectionSortDuplicatedElements() {
        val array = intArrayOf(4, 2, 4, 1, 3, 2)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 4, 4), array)
    }

    @Test
    fun testBidirectionalSelectionSortEmptyArray() {
        val array = intArrayOf()
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(), array)
    }

    @Test
    fun testBidirectionalSelectionSortSingleElementArray() {
        val array = intArrayOf(42)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(42), array)
    }

    @Test
    fun testBidirectionalSelectionSortNegativeElements() {
        val array = intArrayOf(-5, -3, -1, -4, -2)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-5, -4, -3, -2, -1), array)
    }

    @Test
    fun testBidirectionalSelectionSortAllElementsEqual() {
        val array = intArrayOf(7, 7, 7, 7, 7)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(7, 7, 7, 7, 7), array)
    }

    @Test
    fun testBidirectionalSelectionSortMixedWithPositiveNegativeElements() {
        val array = intArrayOf(-2, 5, 0, -7, 3)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-7, -2, 0, 3, 5), array)
    }

    @Test
    fun testBidirectionalSelectionSortLargerArray() {
        val array = intArrayOf(10, 8, 15, 22, 5, 17, 13, 19)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(5, 8, 10, 13, 15, 17, 19, 22), array)
    }

    @Test
    fun testBidirectionalSelectionSortLargerArrayWithNegativeElements() {
        val array = intArrayOf(-10, -8, -15, 0, 50, 300, -22, -5, -17, -13, -19)
        BidirectionalSelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-22, -19, -17, -15, -13, -10, -8, -5, 0, 50, 300), array)
    }
}