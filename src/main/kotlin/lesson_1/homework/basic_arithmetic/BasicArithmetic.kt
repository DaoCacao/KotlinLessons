package lesson_1.homework.basic_arithmetic

/**
 * Basic Arithmetic.
 *
 * Write a program that asks the user for two numbers and operation sign and performs basic arithmetic operations.
 * The program should use a function for each operation, return result and print it.
 *
 * Example of input:
 * - 5, 2, +
 * - 10, 3, -
 *
 * Validate input:
 * - The input should be not empty.
 * - First and second input should contain a number, third - operation sign.
 *
 * Operations:
 * - addition.
 * - subtraction.
 * - multiplication.
 * - division.
 *
 * If input is not valid, print an error message and exit the program.
 *
 * Hard mode: let user enter expression like "5 + 2" and parse it.
 *
 * Super hard mode: let user enter big expression like "5 + 2 * 3 - 1" and parse it using arithmetic rules.
 */

//vararg

fun main(){
    basicMath(2, 55, "b")
}

fun basicMath (x:Int, y:Int, operator: String): Int{
    var c=1
    if (operator=="+"||operator=="-"||operator=="/"||operator=="*"){

        when (operator){
            "+" -> c=x+y
            "-" -> c=x-y
            "*" -> c=x*y
            "/" -> c=x/y
        }
        print("Result is $c")
    } else {
        print ("Error. Enter a correct operator")
    }
    return c
}

fun hurderBasicMath(){

}
