package datastructures.lists

interface List<E> {

    fun addLast(element: E)

    fun addAtIndex(index: Int, element: E)

    fun addFirst(element: E)

    fun set(index: Int, element: E)

    fun removeByIndex(index: Int): E

    fun removeByElement(element: E): E?

    fun removeFirst(): E

    fun removeLast(): E

    fun get(index: Int): E

    fun getFirst(): E

    fun getLast(): E

    fun indexOf(element: E): Int

    fun contains(element: E): Boolean

    fun isEmpty(): Boolean

    fun toArray(): Array<E>

    fun size(): Int

}