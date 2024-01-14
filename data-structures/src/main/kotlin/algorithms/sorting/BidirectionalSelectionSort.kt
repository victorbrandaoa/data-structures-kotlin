package algorithms.sorting

class BidirectionalSelectionSort {
    companion object {
        fun sort(array: IntArray) {
            var i = 0
            var n = array.size-1
            while (i < n) {
                var minI = i
                for (j in i+1 .. n) {
                    if (array[j] < array[minI]) {
                        minI = j
                    }
                }
                swap(array, i, minI)

                var maxI = i
                for (j in i+1 .. n) {
                    if (array[j] > array[maxI]) {
                        maxI = j
                    }
                }
                swap(array, n, maxI)
                i++
                n--
            }
        }
    }
}
