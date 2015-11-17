package name.mikulskibartosz.funwithscala.oo.io

import java.util.Scanner

/**
 * Reads text from the OS console.
 */
class ConsoleReader extends InputReader {
  val scanner = new Scanner(System.in)
  /**
   * Reads a line from the OS console.
   *
   * @return a line
   */
  override def readLine: String = scanner.nextLine()
}

/**
 * Displays a line of text using the OS console.
 */
class ConsoleWriter extends OutputWriter {
  /**
   * Displays a line of text using the OS console.
   *
   * @param line a line
   */
  override def writeLine(line: String): Unit = println(line)
}
