package datastructures.lists

import datastructures.lists.arraylist.ArrayListIterativeImpl
import org.junit.jupiter.api.BeforeEach

class ArrayListIterativeTest {

    private lateinit var list: List<Int>

    @BeforeEach
    fun setUp() {
        list = ArrayListIterativeImpl(5)
    }

}