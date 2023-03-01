package lesson_3.homework

import kotlin.test.assertEquals

/**
 * Lambdas.
 *
 * Make your own implementations of kotlin list functions:
 * - [filter]
 * - [map]
 * - [find]
 * - [forEach]
 *
 * each function should have two parameters - list to process and lambda to apply. function should return result of processing.
 *
 * Example:
 * - filter(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) { it % 2 == 0 } // should return listOf(2, 4, 6, 8, 10)
 * - map(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) { it * 2 } // should return listOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
 *
 * Hint: read a little about those functions in the documentation.
 *
 * You can skip part with generics (<T> stuff) and just use [Int] as type parameter of lists and lambdas.
 * Hard level for self learning: Don't skip, make your functions generic!
 */
fun main() {
    println("filtration")
    assertEquals(listOf(2, 4, 6, 8), filter(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) { it % 2 == 0 })
    assertEquals(listOf("a", "a", "a", "a"), filter(listOf("a", "b", "c", "d", "a", "a", "a")) { it == "a" })
    println("mapping")
    assertEquals(listOf(2.0, 4.0, 6.0), map(listOf(1.0, 2.0, 3.0)) { it * 2 })
    println("foundation")
    assertEquals('3', find(listOf('1', '2', '3')) { it == '3' })
    println("forEaching")
    forEach(listOf(1.0F, 2.0F, 3.0F, 4.0F, 5.0F)) { println(it) }
}

fun <T> filter(list: List<T>, filtration: (item: T) -> Boolean): List<T> {

    var filtredList = mutableListOf<T>()
    for (i in list.indices) {
        if (filtration(list[i])) {
            filtredList.add(list[i])
        }
    }

    return filtredList
}

fun <T> map(list: List<T>, mapping: (item: T) -> T): List<T> {
    var mappedList = mutableListOf<T>()
    for (i in list.indices) {
        mappedList.add(mapping(list[i]))
    }
    return mappedList
}

fun <T> find(list: List<T>, finding: (item: T) -> Boolean): T? {

    var findedItem: T? =null
    for (i in list.indices) {
        if (finding(list[i])) {
            findedItem = list[i]
        }
    }
    return findedItem
}

fun <T> forEach(list: List<T>, forEaching: (item: T) -> Unit): Unit {
    for (i in list.indices) {
        forEaching(list[i])
    }
    return
}

