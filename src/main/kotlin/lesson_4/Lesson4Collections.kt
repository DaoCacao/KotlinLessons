package lesson_4

fun main() {
    // Lists
    mutableListOf<Int>()
    listOf<Int>()


    val stringList = List(5) { "String $it" }
    stringList.get(0) //
    stringList[0]

    val muteList = mutableListOf<Int>(1, 2, 3)
    muteList.add(6) // add to the end
    muteList.add(0, 6) // add to the start (0 index), [6, 1, 2, 3]

    // Maps
    val stringMap = mutableMapOf<String, Int>()
    stringMap["key_name"] = 50
    println(stringMap["key_name"]) // Int
    println(stringMap["key_name_2"]) // Int
    println(stringMap.computeIfAbsent("key_name_2") {
        println("put 500")
        500
    }) // Int
    println(stringMap["key_name_2"]) // Int

    // Sets
    val uniqueSet = mutableSetOf<Int?>(null, 1, 2, 3, 4, 5)
    uniqueSet.add(6)
    uniqueSet.add(6)
    uniqueSet.add(null)
    repeat(10) {
        uniqueSet.add((10 * it) + 1)
    }
    println(uniqueSet)

//    mutableSetOf<>() //LinkedHashSet
    val reorderedSet = hashSetOf<SomeObj<Any>>() //HashSet
    repeat(20) {
        reorderedSet.add(SomeObj(it))
    }
    println(reorderedSet)


}

val usersList = emptyList<User>()
val usersMap = emptyMap<String, User>()
fun getUserName(position: Int): User {
    ///val name = usersList...
    val name = usersList[position]
    return name
}

fun getUserName(id: String): String {
    return usersMap[id]!!.name
}

data class User(
    val id: String,
    val name: String,
)

class SomeObj<T>(val value: T) {
    override fun toString(): String {
        return "SomeObj-$value"
    }
}

class Entry(
    val prev: Entry?,
    val next: Entry?,
)
