package lesson_4.homework

/**
 * Custom list.
 * Create a custom list implementation that supports the following operations:
 * - get: returns the element at the given index
 * - set: sets the element at the given index
 * - add: adds the element to the end of the list
 * - remove: removes the element at the given index
 * - size: returns the number of elements in the list
 * - isEmpty: returns true if the list is empty, false otherwise
 * - contains: returns true if the list contains the element, false otherwise
 *
 * The list should be generic.
 * You can use any storage you want to implement the list, also other collections from the standard library, except the built-in List.
 * If index is out of bounds, throw IndexOutOfBoundsException.
 *
 * To test implementation you can use the following code:
 * ```
 * val list = CustomList<String>()
 * list.add("one")
 * list.add("two")
 * list.add("three")
 *
 * // get
 * assertEquals(list.get(0), "one")
 * assertEquals(list.get(1), "two")
 * assertEquals(list.get(2), "three")
 * assertFailsWith(IndexOutOfBoundsException::class) { list.get(3) }
 *
 * // set
 * list.set(0, "ONE")
 * list.set(1, "TWO")
 * list.set(2, "THREE")
 * list.set(3, "FOUR")
 * assertEquals(list.get(0), "ONE")
 * assertEquals(list.get(1), "TWO")
 * assertEquals(list.get(2), "THREE")
 * assertEquals(list.get(3), "FOUR")
 *
 * // add
 * list.add("five")
 * assertEquals(list.get(4), "five")
 *
 * // remove
 * list.remove(0)
 * assertEquals(list.get(0), "TWO")
 * list.remove(1)
 * assertEquals(list.get(1), "FOUR")
 *
 * // size
 * assertEquals(list.size(), 3)
 * list.remove(0)
 * assertEquals(list.size(), 2)
 *
 * // isEmpty
 * assertEquals(list.isEmpty(), false)
 * list.remove(0)
 * list.remove(0)
 * assertEquals(list.isEmpty(), true)
 * ```
 *
 * Additional:
 * - Read about operators in Kotlin and make get() and set() as operator functions.
 * - add a constructor that takes a count of elements and a lambda function that returns an element by its index.
 * - add(index, element): adds the element at the given index
 */