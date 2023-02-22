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
    println("mapping")
    assertEquals(listOf(2, 4, 6), map(listOf(1, 2, 3)) { it * 2 })
    println("foundation")
    assertEquals(3, find(listOf(1, 2, 3)) { it==3 })
    println("forEaching")
    forEach(listOf(1,2,3,4,5)){ println(it) }

}

fun filter(list: List<Int>, filtration: (item: Int) -> Boolean): List<Int> {

    var filtredList = mutableListOf<Int>()
    for (i in list.indices) {
        if (filtration(list[i])) {
            filtredList.add(list[i])
        }
    }

    return filtredList
}

fun map(list: List<Int>, mapping: (item: Int) -> Int): List<Int> {
    var mappedList = mutableListOf<Int>()
    for (i in list.indices) {
        mappedList.add(mapping(list[i]))
    }
    return mappedList
}

fun find(list: List<Int>, finding: (item: Int) -> Boolean): Int {

    var findedItem=0
    for (i in list.indices) {
        if (finding(list[i])) {
            findedItem = list[i]
        }
    }
    return findedItem
}

fun forEach(list: List<Int>, forEaching: (item: Int) -> Unit): Unit {
    for (i in list.indices) {
        forEaching(list[i])
    }
    return
}

