package name.mikulskibartosz.funwithscala.oo.io

/**
 * Reads a line of text from an input device.
 */
trait InputReader {
  /**
   * Reads a line from an input device.
   *
   * @return a line
   */
  def readLine: String
}

/**
 * Sends a line of text to an output device.
 */
trait OutputWriter {
  /**
   * Sends a line to an output device.
   *
   * @param line a line
   */
  def writeLine(line: String): Unit
}
