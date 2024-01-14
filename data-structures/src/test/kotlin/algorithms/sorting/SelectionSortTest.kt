package algorithms.sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SelectionSortTest {

    @Test
    fun testSelectionSort() {
        val array = intArrayOf(5, 3, 1, 4, 2)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testSelectionSortAlreadySortedArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testSelectionSortDescendingSortedArray() {
        val array = intArrayOf(9, 7, 5, 3, 1)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 3, 5, 7, 9), array)
    }

    @Test
    fun testSelectionSortDuplicatedElements() {
        val array = intArrayOf(4, 2, 4, 1, 3, 2)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 4, 4), array)
    }

    @Test
    fun testSelectionSortEmptyArray() {
        val array = intArrayOf()
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(), array)
    }

    @Test
    fun testSelectionSortSingleElementArray() {
        val array = intArrayOf(42)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(42), array)
    }

    @Test
    fun testSelectionSortNegativeElements() {
        val array = intArrayOf(-5, -3, -1, -4, -2)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-5, -4, -3, -2, -1), array)
    }

    @Test
    fun testSelectionSortAllElementsEqual() {
        val array = intArrayOf(7, 7, 7, 7, 7)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(7, 7, 7, 7, 7), array)
    }

    @Test
    fun testSelectionSortMixedWithPositiveNegativeElements() {
        val array = intArrayOf(-2, 5, 0, -7, 3)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-7, -2, 0, 3, 5), array)
    }

    @Test
    fun testSelectionSortLargerArray() {
        val array = intArrayOf(10, 8, 15, 22, 5, 17, 13, 19)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(5, 8, 10, 13, 15, 17, 19, 22), array)
    }

    @Test
    fun testSelectionSortLargerArrayWithNegativeElements() {
        val array = intArrayOf(-10, -8, -15, 0, 50, 300, -22, -5, -17, -13, -19)
        SelectionSort.sort(array)
        assertArrayEquals(intArrayOf(-22, -19, -17, -15, -13, -10, -8, -5, 0, 50, 300), array)
    }
}