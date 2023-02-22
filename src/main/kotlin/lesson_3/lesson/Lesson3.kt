package lesson_3.lesson

import kotlin.random.Random

fun main() {
    lambdas()
}

fun lambdas() {
    val result = someFun()

    someLongAction(
        onSuccess = {
            //Hard logic
            val text = "ХАХА"
            val text2 = "Сучки"
            val result = text + " " + text2
            result
        },
        onFailure = { println(it) },
        onTripleSucces = { "ПОВЕЗЛОООО" },
    )

    sugar { println("Override 2") }
}

fun sugar(
    action1: () -> Unit = { println("action1") },
    action2: () -> Unit = { println("action2") },
) {
    action1()
    action2()
}

fun someLongAction(
    onSuccess: () -> String,
    onFailure: (Throwable) -> Unit,
    onTripleSucces: () -> String,
) {
    var success = 0
    for (i in 0..3) {
        //Some long action tatata
        if (Random.nextBoolean()) {
            success++
            val successText = onSuccess()
            println(successText)
            if (success == 3) {
                println(onTripleSucces())
                break
            }
        } else {
            onFailure(RuntimeException("Не повезло!"))
            break
        }
    }
}

fun lambdaAsParameter(param: () -> Unit) {
    param()
}

fun lambdaAsVariable() {
    val myLambda: () -> Unit = {
        println("hello from lambda")
    }

    val myLambda2 = myLambda

    myLambda2()
    myLambda2.invoke()
}

fun stackoverflow() {
    var something: () -> Unit
    something = {}
    something = { something() }
    something()
}

fun someFun(): Int {
    return 0
}

fun tryCatch() {
    // try catch
    println("попытка разделить")
    val result: Int = division(10, 0)
    println("деление успешно!")

    println("result: $result")
}

fun withFinally() {
    try {
        //write to file, IOException
        println("Пытается")
    } catch (e: Throwable) {
        println("Если ошибка")
    } finally {
        // need to close the file
        println("В любом случае выполнится")
    }
}

// Делим A на B, но если ошибка, возвращаем -1
fun division(a: Int, b: Int): Int {
    val value1 = try {
        a / b
    } catch (e: ArithmeticException) {
        -1
    }

    val value2 = runCatching { a / b }.onFailure { -1 }.getOrThrow()

    return try {
        a / b
    } catch (e: ArithmeticException) {
        -1
    }
}