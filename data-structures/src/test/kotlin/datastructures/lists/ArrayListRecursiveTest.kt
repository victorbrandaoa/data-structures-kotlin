package datastructures.lists

import datastructures.lists.arraylist.ArrayListRecursiveImpl
import org.junit.jupiter.api.BeforeEach

class ArrayListRecursiveTest {

    private lateinit var list: List<Int>

    @BeforeEach
    fun setUp() {
        list = ArrayListRecursiveImpl(5)
    }

}