package datastructures.lists

interface List<E> {

    fun add(element: E)

    fun add(index: Int, element: E)

    fun set(index: Int, element: E)

    fun remove(index: Int): E

    fun remove(element: E): E

    fun get(index: Int): E

    fun indexOf(element: E): Int

    fun contains(element: E): Boolean

}