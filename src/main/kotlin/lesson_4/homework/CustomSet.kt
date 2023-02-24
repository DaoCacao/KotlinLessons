package lesson_4.homework

/**
 * Custom set.
 * Create a custom set implementation that supports the following operations:
 * - add: adds the element to the set
 * - remove: removes the element from the set
 * - size: returns the number of elements in the set
 * - isEmpty: returns true if the set is empty, false otherwise
 * - contains: returns true if the set contains the element, false otherwise
 *
 * The set should be generic.
 * You can use any storage you want to implement the set, also other collections from the standard library, except the built-in Set.
 *
 * To test implementation you can use the following code:
 * ```
 * val set = CustomSet<String>()
 * set.add("one")
 * set.add("two")
 * set.add("three")
 *
 * // add
 * set.add("one")
 * assertEquals(set.size(), 3)
 * set.add("one")
 * assertEquals(set.size(), 3)
 * assertEquals(set.contains("one"), true)
 * set.add("four")
 * assertEquals(set.size(), 4)
 * assertEquals(set.contains("four"), true)
 *
 * // remove
 * set.remove("one")
 * assertEquals(set.size(), 3)
 * assertEquals(set.contains("one"), false)
 * set.remove("four")
 * assertEquals(set.size(), 2)
 * assertEquals(set.contains("four"), false)
 *
 * // size
 * assertEquals(set.size(), 2)
 * set.remove("two")
 * assertEquals(set.size(), 1)
 * set.remove("three")
 * assertEquals(set.size(), 0)
 *
 * // isEmpty
 * assertEquals(set.isEmpty(), true)
 * set.add("one")
 * assertEquals(set.isEmpty(), false)
 * set.remove("one")
 * assertEquals(set.isEmpty(), true)
 *
 * // contains
 * assertEquals(set.contains("one"), false)
 * set.add("one")
 * assertEquals(set.contains("one"), true)
 * set.remove("one")
 * assertEquals(set.contains("one"), false)
 * ```
 *
 * Additional:
 * - Read about varargs and add a constructor with vararg parameter: creates a set with the given elements.
 * - Add addAll function: adds all elements from the given collection to the set
 * - Add clear function: removes all elements from the set
 */
