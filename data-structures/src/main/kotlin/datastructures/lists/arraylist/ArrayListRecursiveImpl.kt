package datastructures.lists.arraylist

import datastructures.lists.List
import datastructures.lists.arraylist.exceptions.ArrayIndexOutOfBoundsException

class ArrayListRecursiveImpl<E> : List<E> {

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
        return recursiveCopy(0, array)
    }

    override fun size(): Int {
        return size
    }

    override fun contains(element: E): Boolean {
        return recursiveContains(0, element)
    }

    private tailrec fun recursiveContains(index: Int, element: E): Boolean {
        if (index == size) {
            return false
        }
        if (elements[index] == element) {
            return true
        }
        return recursiveContains(index + 1, element)
    }

    override fun indexOf(element: E): Int {
        return recursiveIndexOf(0, element)
    }

    private tailrec fun recursiveIndexOf(index: Int, element: E): Int {
        if (index == size) {
            return -1
        }
        if (elements[index] == element) {
            return index
        }
        return recursiveIndexOf(index + 1, element)
    }

    override fun removeByElement(element: E): E? {
        val i = indexOf(element)
        return when {
            i > -1 -> removeByIndex(i)
            else -> null
        }
    }

    private tailrec fun shiftLeft(index: Int) {
        if (index < size) {
            elements[index] = elements[index+1]
            shiftLeft(index + 1)
        }
    }

    private tailrec fun shiftRight(index: Int) {
        if (index < size) {
            elements[index+1] = elements[index]
            shiftRight(index + 1)
        }
    }

    private fun ensureCapacity(nextSize: Int) {
        if (nextSize > elements.size) {
            resize(elements.size * 2)
        }
    }

    private fun resize(newLength: Int) {
        val newElements: Array<E> = arrayOfNulls<Any>(newLength) as Array<E>
        elements = recursiveCopy(0, newElements)
    }

    private tailrec fun recursiveCopy(index: Int, acc: Array<E>): Array<E> {
        if (index == size) {
            return acc
        }
        acc[index] = elements[index]
        return recursiveCopy(index + 1, acc)
    }

    private fun validateIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw ArrayIndexOutOfBoundsException()
        }
    }
}