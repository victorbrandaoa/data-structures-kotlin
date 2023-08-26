package datastructures.lists.arraylist

import datastructures.lists.List
import datastructures.lists.arraylist.exceptions.ArrayIndexOutOfBoundsException

class ArrayListIterativeImpl<E> : List<E> {

    private val INITIAL_LENGTH: Int = 10
    private var elements: Array<E>
    private var size: Int = 0

    constructor() {
        elements = arrayOfNulls<Any>(INITIAL_LENGTH) as Array<E>
    }


    constructor(initialLength: Int) {
        elements = arrayOfNulls<Any>(initialLength) as Array<E>
    }

    override fun addLast(element: E) {
        ensureCapacity(size + 1)
        elements[size++] = element
    }

    override fun addAtIndex(index: Int, element: E) {
        validateIndex(index)
        ensureCapacity(size + 1)
        shiftRight(index)
        elements[index] = element
        size++
    }

    override fun addFirst(element: E) {
        addAtIndex(0, element)
    }

    override fun set(index: Int, element: E) {
        validateIndex(index)
        elements[index] = element
    }

    override fun removeByIndex(index: Int): E {
        validateIndex(index)
        val element = elements[index]
        shiftLeft(index)
        size--
        return element
    }

    override fun removeFirst(): E {
        return removeByIndex(0)
    }

    override fun removeLast(): E {
        return elements[--size]
    }

    override fun get(index: Int): E {
        validateIndex(index)
        return elements[index]
    }

    override fun getFirst(): E {
        return get(0)
    }

    override fun getLast(): E {
        return get(size - 1)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toArray(): Array<E> {
        val array: Array<E> = arrayOfNulls<Any>(size) as Array<E>
        return copy(array)
    }

    override fun size(): Int {
        return size
    }

    override fun contains(element: E): Boolean {
        for (i in 0 until size) {
            if (elements[i] == element) {
                return true
            }
        }
        return false
    }

    override fun indexOf(element: E): Int {
        for (i in 0 until size) {
            if (elements[i] == element) {
                return i
            }
        }
        return -1
    }

    override fun removeByElement(element: E): E? {
        val i = indexOf(element)
        return when {
            i > -1 -> removeByIndex(i)
            else -> null
        }
    }

    private fun shiftLeft(index: Int) {
        for (i in index until elements.size-1) {
            elements[i] = elements[i+1]
        }
    }

    private fun shiftRight(index: Int) {
        for (i in elements.size-1 downTo index+1) {
            elements[i] = elements[i-1]
        }
    }

    private fun ensureCapacity(nextSize: Int) {
        if (nextSize > elements.size) {
            resize(elements.size * 2)
        }
    }

    private fun resize(newLength: Int) {
        val newElements: Array<E> = arrayOfNulls<Any>(newLength) as Array<E>
        elements = copy(newElements)
    }

    private fun copy(resultArray: Array<E>): Array<E> {
        for (i in elements.indices) {
            resultArray[i] = elements[i]
        }
        return resultArray
    }

    private fun validateIndex(index: Int) {
        if (index < 0 || index >= elements.size) {
            throw ArrayIndexOutOfBoundsException()
        }
    }
}