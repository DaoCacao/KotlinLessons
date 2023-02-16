fun main() {

    fibonachi(5)
}

fun fibonachi(ind: Int): Int {
    var i = 1
    var fib1 = 0
    var fib2 = 1
    var fib3 = 0

    while (i != ind) {

        fib3 = fib1 + fib2
        fib1 = fib2
        fib2 = fib3
        i++
    }
    when (i) {
        1 -> return 0
        2 -> return 1
        else -> return fib3
    }
}