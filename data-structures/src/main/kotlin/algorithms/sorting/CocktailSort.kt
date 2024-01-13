package algorithms.sorting

class CocktailSort {
    companion object {
        private fun swap(array: IntArray, i: Int, j: Int) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }

        fun sort(array: IntArray) {
            var swapped = true

            var start = 0
            val end = array.size -1
            while (swapped) {
                swapped = false

                var j = end - start
                for (i in start until j) {
                    if (array[i] > array[i+1]) {
                        swap(array, i, i+1)
                        swapped = true
                    }

                    if (array[j] < array[j-1]) {
                        swap(array, j, j-1)
                        swapped = true
                    }
                    j -= 1
                }
                start += 1
            }
        }
    }
}