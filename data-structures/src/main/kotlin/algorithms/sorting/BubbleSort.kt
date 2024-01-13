package algorithms.sorting

class BubbleSort {
    companion object {
        private fun swap(array: IntArray, i: Int, j: Int) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }

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
