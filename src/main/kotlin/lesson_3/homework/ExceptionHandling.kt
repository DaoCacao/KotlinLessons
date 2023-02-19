package lesson_3.homework

import java.io.FileNotFoundException
import java.io.IOException

/**
 * Exception Handling.
 *
 * Your program should call [someFileOperation] function and print result to the console.
 * You should handle possible exceptions that can be thrown by [someFileOperation] function and print meaningful messages to the console.
 * Make two versions of your program:
 * - First version should use `try-catch` blocks.
 * - Second version should use kotlin `try-catch` expression.
 *
 * Hint: to read a documentation is always a good idea.
 */
fun main() {
    TODO("Implement me")
}


/**
 * Some interesting work with a file.
 *
 * Returns file content as [String] if file exists and read without errors.
 * Throws [FileNotFoundException] if file not found.
 * Throws [IOException] if file read error occurred.
 * Throws [NumberFormatException] if file content is not a number.
 * Throws [Exception] if unknown error occurred.
 */
fun someFileOperation(): String {
    when (FileResult.values().random()) {
        FileResult.SUCCESS -> return "4 8 15 16 23 42"
        FileResult.FILE_NOT_FOUND -> throw FileNotFoundException()
        FileResult.IO -> throw IOException()
        FileResult.NUMBER_FORMAT -> throw NumberFormatException()
        FileResult.UNKNOWN_ERROR -> throw Exception()
    }
}

/**
 * Possible results of file operation.
 */
enum class FileResult {
    SUCCESS, FILE_NOT_FOUND, IO, NUMBER_FORMAT, UNKNOWN_ERROR,
}