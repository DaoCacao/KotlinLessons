package lesson_4

// Generics
fun main() {
    val stringBox = Box("String object")
    println(stringBox.boxObject)
    println(stringBox.boxObject.toString())

    val intBox = Box(15)
    println(intBox.boxObject)
    println(intBox.boxObject.toString().toInt() + 10)

    val sockBox = Box(Sock())
    println(sockBox.boxObject)
    println((sockBox.boxObject as Sock).sniff())

    val genericSockBox = GenericBox(Sock())

    genericSockBox.boxObject.sniff()

    val genericStringBox = GenericBox("String bitch")

    val fridge = Fridge(Food())
    fridge.boxObject.eat()

    val fridgeWithFood = Fridge(Banana())
    (fridgeWithFood.boxObject as Banana).stickIntoAss()

//    val genericFridge = GenericFridge(Food())
    val genericFridge = GenericFridge(Banana())
//    val genericFridge = GenericFridge(Cola())

    genericFridge.boxObject.stickIntoAss()
//    genericFridge.boxObject.drink()


    val multiGenericFridge = MultiGenericFridge(NewFood())
}

class Box(
    val boxObject: Any,
)

class Sock {
    fun sniff() {
        println("ААААХХХ")
    }
}

open class GenericBox<T>(
    val boxObject: T
)

open class Water : Food() {
    fun drink() {}
}

class Banana : Food(), Eatable {
    fun stickIntoAss() {

    }
}

class Cola : Water()

open class Food {
    fun eat() {
        println("om nom nom")
    }
}

interface Eatable {
    fun eat()
}

interface Drinkable {
    fun drink()
}

class NewFood : Eatable, Drinkable {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun drink() {
        TODO("Not yet implemented")
    }
}

class MotorOil : Drinkable {
    override fun drink() {
        TODO("Not yet implemented")
    }
}

class Medicine : Drinkable {
    override fun drink() {
        TODO("Not yet implemented")
    }

}

class AnyClass

// Generic with predefined type
class Fridge(boxObject: Food) : GenericBox<Food>(boxObject) {

    fun open() {
        //
    }

    fun close() {
        //
    }
}

// Generic with instance type
class GenericFridge<F : Food>(boxObject: F) : GenericBox<F>(boxObject) {

}

// How to add multiple types
//class MultiGenericFridge<Item : Drinkable, Item : Eatable>
class MultiGenericFridge<Item>(boxObject: Item) : GenericBox<Item>(boxObject) where Item : Drinkable, Item : Eatable