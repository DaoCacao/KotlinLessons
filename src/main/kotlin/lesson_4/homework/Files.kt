package lesson_4.homework

import java.io.File
import java.nio.charset.Charset

/**
 * So if you successfully implemented your own collections, you can read about file system in Kotlin.
 * https://www.studytonight.com/kotlin/kotlin-file-handling
 *
 * To do:
 * - Read about work with files in Kotlin.
 * - Create a file with the name "file.txt" in the root of the project.
 * - Write the following text to the file: "Hello, world!"
 * - Read the text from the file and print it to the console (file should be closed after using, use close() method or use() function, read about both).
 *
 * Feel free to implement your collections using the file system (make separate implementation for each collection).
 *
 * Good luck!
 */

fun main() {

    val fileName = "fileHW.txt"
    val fileZapis = File(fileName).writeText("Ебать, смотри чё сделал")
    println(File(fileName).readText(Charset.forName("UTF-8")))

    writeAndReadFile("fileHW.txt", "Ebat cho proishodit")

}

fun writeAndReadFile(file: String, text: String) {
    val fileZapis = File(file).appendText("\n $text")
    File(file).useLines { println(File(file).readText(Charset.forName("UTF-8"))) }

}