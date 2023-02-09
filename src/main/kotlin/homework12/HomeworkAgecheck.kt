/**
 * Age check.
 *
 * Create a program that takes in a user's age and determines if they are a teenager or not based on their age.
 * The program should use a function to determine it, return the result and print it.
 * If age is between 13 and 19 (inclusive), print "teenager".
 * If age is less than 13 or greater than 19, print "not a teenager".
 *
 * Validate input:
 * - The input should be not empty.
 * - The input should contain a number.
 * - The input should be a positive number.
 *
 * If input is not valid, print an error message and exit the program.
 *
 */

fun main() {

    var x: Int? = readln()!!.toIntOrNull()

    ageCheck(x)
}

fun ageCheck(x: Int?): String {

    var message: String

    when (x) {
        in 13..19 -> {
            message = "User is a teenager"
            print(message)
        }

        null -> {
            message = "Error. Enter correct number"
            print(message)
        }

        else -> {
            message = "User is not a teenager"
            print(message)
        }
    }
    return message
}
