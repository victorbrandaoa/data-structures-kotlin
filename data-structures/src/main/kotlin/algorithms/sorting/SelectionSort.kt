package algorithms.sorting

class SelectionSort {
    companion object {
        fun sort(array: IntArray) {
            for (i in array.indices) {
                var minI = i
                for (j in i+1 until array.size) {
                    if (array[j] < array[minI]) {
                        minI = j
                    }
                }
                swap(array, i, minI)
            }
        }
    }
}
