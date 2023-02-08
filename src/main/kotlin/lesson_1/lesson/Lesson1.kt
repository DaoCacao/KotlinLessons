package lesson_1.lesson

fun main(args: Array<String>) {
//    // Примитивные
//
//    // Int 2kkk
//    val sum: Int = 5 + 10
//    println(sum) // 15
//
//    val bigSum: Int = 20 * 1000 * 1000 * 1000
//    println(bigSum) // throw error
//
//    // Long
//    // Boolean
//    // Float
//    // Double
//    // char = 'h'
//    // String = ""

//    val work: String = "Blabla"
//    val work1: String = work
//    println(work == work1)
//
//    // Ссылочные
//    val obj1: lesson_1.lesson.SomeObject = lesson_1.lesson.SomeObject()
//    val obj2: lesson_1.lesson.SomeObject = obj1
//
//    println(obj1.name) // "blabla"
//    println(obj2.name) // "blabla" same
//
//    obj1.name = "not bla bla"
//    println(obj1.name) // "not bla bla"
//    println(obj2.name) // "not bla bla"

    val number0: Int = 5
    val number1: Int = 2
    val number2: Int = 3
    val number3: Int = number1 + number2
    println("number0: ${number0.hashCode()}")
    println("number1: ${number1.hashCode()}")
    println("number2: ${number2.hashCode()}")
    println("number3: ${number3.hashCode()}")

    val object1 = SomeObject()
    val object2 = SomeObject()

    println(object1.name) // "blabla"
    println(object2.name) // "blabla"

//    object1.name = "123"
//
//    println(object1.name) // "123"
//    println(object2.name) // "blabla"

//    val fragment = Fragment()
//    val fragment2 = fragment

    println(object1)
    println(object2)
    println(object1 == object2) // true

    println(object1.copy(humor = "22"))

}

//class lesson_1.lesson.SomeObject(
//    val name: String = "blabla"
//) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as lesson_1.lesson.SomeObject
//
//        if (name != other.name) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return name.hashCode()
//    }
//}

data class SomeObject(
    val name: String = "name",
    val phone: String = "phone",
    val age: String = "age",
    val humor: String = "humor",
)