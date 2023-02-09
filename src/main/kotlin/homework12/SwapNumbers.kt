/**
 * Swap numbers.
 *
 * Write a program that has two variables with integer values and then swap their values.
 *
 * Example:
 * ```
 * var a = 1
 * var b = 2
 * println(a) // 1
 * println(b) // 2
 * // some magic here
 * println(a) // 2
 * println(b) // 1
 * ```
 *
 * Light mode: use a third variable.
 * Hard mode: don't use a third variable.
 */


//SwapEasy
fun main() {

    println("Easymode")

    var c: Int
    var x = 1
    var y = 2
    println("x is $x")
    println("y is $y")

    c = x
    x = y
    y = c

    println("Some magic happens")
    println("Vjuuuhh")
    println("x is $x")
    println("y is $y")

    println("\nHardmode\n")

    var x1 = 1
    var y1 = 2

    println("x is $x")
    println("y is $y")

    x = y.also { y = x }

    println("Some fucking awesome magic happens")
    println("Vjuuuhh")

    println("x is $x")
    println("y is $y")

}



