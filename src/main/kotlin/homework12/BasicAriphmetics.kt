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


fun main() {

    basicMath(2, 55, "-")
    println("\n//////////////")
    hardBasicMath("10+10")
    println("\n//////////////")
    superHardBasicMath("2*4")

}

fun basicMath(x: Int, y: Int, operator: String): Int? {

    when (operator) {
        "+" -> {
            print("Result is ${x + y}")
            return x + y
        }

        "-" -> {
            print("Result is ${x - y}")
            return x - y
        }

        "*" -> {
            print("Result is ${x * y}")
            return x * y
        }

        "/" -> {
            print("Result is ${x / y}")
            return x / y
        }

        else -> {
            print("Error. Enter a correct operator")
            return null
        }

    }
}

fun hardBasicMath(expression: String): Int? {
    val expressionNumbers = expression.filterNot { it.isLetter() }
    val expressionOperator = expression.filterNot { it.isDigit() }
    var answer: Int
    var temporalAnswers = mutableListOf<Int>()

    for (i in expression.indices) {
        if (i == 0 && expression[i] == '-') {
        }
    }

    when (expressionOperator) {
        "+" -> {
            answer = expressionNumbers[0].digitToInt() + expressionNumbers[1].digitToInt()
            print("Result is ${answer}")
            return answer
        }

        "-" -> {
            answer = expressionNumbers[0].digitToInt() - expressionNumbers[1].digitToInt()
            print("Result is ${answer}")
            return answer
        }

        "*" -> {
            answer = expressionNumbers[0].digitToInt() * expressionNumbers[1].digitToInt()
            print("Result is ${answer}")
            return answer
        }

        "/" -> {
            answer = expressionNumbers[0].digitToInt() * expressionNumbers[1].digitToInt()
            print("Result is ${answer}")
            return answer
        }

        else -> {
            print("Error. Enter a correct expression")
            return null
        }
    }
}

fun superHardBasicMath(expression: String) {

    val expressionNumbers = expression.filter { it.isDigit() }
    val expressionOperator = expression.filterNot { it.isDigit() }
    var answer: Int

    var temporalExpression = expression.toMutableList()
    println(temporalExpression)

    for (i in expression.indices) {
        var temporalResult: Int
        if (expression[i] == '*' || expression[i] == '/') {
            when (expressionOperator) {
                "*" -> {
                    temporalResult = expression[i - 1].digitToInt() * expression[i + 1].digitToInt()

                    println(temporalResult)

                    temporalExpression.add(i, temporalResult.toChar())

                    temporalExpression.removeAt(i + 1)
                    temporalExpression.removeAt(i - 1)
                    temporalExpression.add(i - 1, temporalResult.toChar())
                    temporalExpression.removeAt(i)
                    println(temporalExpression)

                }

                "/" -> {
                    temporalResult = expression[i - 1].digitToInt() / expression[i + 1].digitToInt()
                    println(temporalResult)
                    temporalExpression.add(temporalResult.toChar())
                }
            }
        }
        if (expression[i] == '+' || expression[i] == '-') {
            when (expressionOperator) {
                "+" -> {
                    temporalResult = expression[i - 1].digitToInt() * expression[i + 1].digitToInt()
                    println(temporalResult)
                    temporalExpression.add(temporalResult.toChar())
                }

                "-" -> {
                    temporalResult = expression[i - 1].digitToInt() / expression[i + 1].digitToInt()
                    println(temporalResult)
                    temporalExpression.add(temporalResult.toChar())
                }
            }
        }
    }

    for (i in temporalExpression.indices) {


    }

//    when (expressionOperator) {
//        "+" -> {
//            answer=expressionNumbers[0].digitToInt() + expressionNumbers[1].digitToInt()
//            print("Result is ${answer}")
//            return answer
//        }
//
//        "-" -> {
//            answer=expressionNumbers[0].digitToInt() - expressionNumbers[1].digitToInt()
//            print("Result is ${answer}")
//            return answer
//        }
//
//        "*" -> {
//            answer=expressionNumbers[0].digitToInt() * expressionNumbers[1].digitToInt()
//            print("Result is ${answer}")
//            return answer
//        }
//
//        "/" -> {
//            answer=expressionNumbers[0].digitToInt() * expressionNumbers[1].digitToInt()
//            print("Result is ${answer}")
//            return answer
//        }
//
//        else -> {
//            print("Error. Enter a correct operator")
//            return null
//        }
//
//    }
}
