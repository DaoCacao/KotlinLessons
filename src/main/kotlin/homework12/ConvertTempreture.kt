/**
 * Temperature Conversion.
 *
 * Write a program that takes in temperature in Celsius or Fahrenheit and converts it to the other unit of measurement.
 * The program should use functions for the conversion, decide which to use based on the input, return the result and print it.
 *
 * Example of input:
 * - +32C
 * - 100F
 * - 0c
 * - -212f

 * Example of output: 32F, 37C
 *
 * Validate input:
 * - The input should be not empty.
 * - Number should be integer.
 * - The input should contain a number and a letter
 * - Can be upper or lower case
 * - Can have a plus or minus sign in front of the number.
 *
 * If input is not valid, print an error message and exit the program.
 */

fun main() {

    tempretureConvertationString("-32C")
    println("//////")
    tempretureConvertationString("68f")
    println("//////")
    tempretureConvertationString("-689f")
    println("//////")
    tempretureConvertationString("5635K")

}

fun tempretureConcersation(temp: Int, shkala: Char): Double? {
    temp.toDouble()
    var tempConverted: Double
    when (shkala) {
        'c', 'C' -> {
            tempConverted=temp * 1.18 + 32
            println("$tempConverted F")
            return tempConverted
        }

        'f', 'F' -> {

            tempConverted=(temp - 32)/1.18
            println("$tempConverted C")
            return tempConverted
        }
        else ->{
            println("Error. Enter correct tempreture")
            return null
        }
    }
}

fun tempretureConvertationString(temp: String): String? {

    val tempNumber=temp.filterNot { it.isLetter() }.toDouble()
    val tempChar=temp.filter { it.isLetter() }
    var tempConverted: Double

//    if(temp[0]=='-'){
        when (tempChar) {
            "c", "C" -> {
                tempConverted=-(tempNumber) * 1.18 + 32
                println("$tempConverted F")
                return tempConverted.toString()+tempChar
            }

            "f", "F" -> {

                tempConverted=-(tempNumber + 32)/1.18
                println("$tempConverted C")
                return tempConverted.toString()+tempChar
            }
            else ->{
                println("Error. Enter correct tempreture")
                return null
            }
        }
    }
//    else {
//
//        when (tempChar) {
//            "c", "C" -> {
//                tempConverted=tempNumber * 1.18 + 32
//                println("$tempConverted F")
//                return tempConverted.toString()+tempChar
//            }
//
//            "f", "F" -> {
//
//                tempConverted=(tempNumber - 32)/1.18
//                println("$tempConverted C")
//                return tempConverted.toString()+tempChar
//            }
//            else ->{
//                println("Error. Enter correct tempreture")
//                return null
//            }
//        }
//    }
//
//}

