package lesson_1.homework.basic_arithmetic.solution

import kotlin.test.assertEquals

fun main() {
    // Without operation
//    assertEquals(1.0, calculate("1"))

    // Simple operations
    assertEquals(10.0, calculate("5 + 5"))
    assertEquals(4.0, calculate("5 - 1"))
    assertEquals(15.0, calculate("5 * 3"))
    assertEquals(5.0, calculate("10 / 2"))

    // Complicated operations
    assertEquals(0.0, calculate("1 + 2 - 3"))
    assertEquals(2.0, calculate("1 - 2 + 3"))
    assertEquals(6.0, calculate("1 + 2 + 3"))
    assertEquals(-4.0, calculate("1 - 2 - 3"))

    assertEquals(5.0, calculate("1 * 2 + 3"))
    assertEquals(7.0, calculate("1 + 2 * 3"))
    assertEquals(2.0, calculate("2 * 3 / 3"))
    assertEquals(4.0, calculate("6 / 3 * 2"))
    assertEquals(127.0, calculate("2 + 5 * 5 + 10 * 10"))
}

fun calculate(expression: String): Double {
    val tokens = expression.split(" ")
    var index = 0

    fun parseNumber(): Double {
        val token = tokens[index++]
        return if (token.matches(Regex("-?\\d+(\\.\\d+)?"))) token.toDouble()
        else throw IllegalArgumentException("Invalid token: $token")
    }

    fun parseTerm(): Double {
        var value = parseNumber()
        while (index < tokens.size && (tokens[index] == "*" || tokens[index] == "/")) {
            when (tokens[index++]) {
                "*" -> value *= parseNumber()
                "/" -> value /= parseNumber()
            }
        }
        return value
    }

    fun parseExpression(): Double {
        var value = parseTerm()
        while (index < tokens.size && (tokens[index] == "+" || tokens[index] == "-")) {
            when (tokens[index++]) {
                "+" -> value += parseTerm()
                "-" -> value -= parseTerm()
            }
        }
        return value
    }

    return parseExpression()
}
