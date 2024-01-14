package algorithms.sorting

class BubbleSort {
    companion object {
        fun sort(array: IntArray) {
            var swapped = true
            var end = array.size -1

            while (swapped) {
                swapped = false

                for (i in 0 until end) {
                    if (array[i] > array[i+1]) {
                        swap(array, i, i+1)
                        swapped = true
                    }
                }
                end -= 1
            }
        }
    }
}
