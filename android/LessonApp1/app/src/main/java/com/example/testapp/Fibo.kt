package com.example.testapp

class Fibo {

    fun fibonachi(positionNumber: Int?): Int {
        var i = 1

        when (positionNumber) {
            null, 0, 1 -> return 0
            2 -> return 1
            else -> {
                var fib1 = 0
                var fib2 = 1
                var fib3 = 0

                while (i != positionNumber) {
                    fib3 = fib1 + fib2
                    fib1 = fib2
                    fib2 = fib3
                    i++
                }
                return fib3
            }
        }
    }
}