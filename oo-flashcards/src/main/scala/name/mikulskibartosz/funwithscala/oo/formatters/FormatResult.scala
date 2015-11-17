package name.mikulskibartosz.funwithscala.oo.formatters

import name.mikulskibartosz.funwithscala.oo.questions.Answer

/**
 * Formats a test result that consists of a list of incorrect answers and the number of correct
 * answers.
 *
 * Returns the result in the following format:
 * "Number of correct answers: n
 *
 * Incorrect answers:
 * {a question}? {the user's answer} correct: {the correct answer}
 */
object FormatResult {

  /**
   * The format of the result used if the user has not made a mistake.
   */
  private val correctFormat = "Number of correct answers: %s"
  /**
   * The format of the result that contains a list of incorrect answers.
   */
  private val format = "Number of correct answers: %s%n%nIncorrect answers:%n%s"

  /**
   * The format of a line that contains the incorrect and expected answer.
   */
  private val incorrectAnswerDescriptionFormat = "%s? %s correct:%s%n"

  /**
   * Formats a test result that consists of a list of incorrect answers and the number of correct
   * answers.
   *
   * @param numberOfCorrectAnswers the number of correct answers
   * @param incorrectAnswers a list of answers
   * @return the formatted result
   */
  def apply(numberOfCorrectAnswers: Int, incorrectAnswers: List[Answer]): String = {
    val formattedIncorrectAnswers = incorrectAnswers
      .map{a => (a.question, a)}
      .map{
        case (q, a) => String.format(incorrectAnswerDescriptionFormat, q.question, a.answer, q.correctAnswer)
      }.foldRight("")(_ + _)

    if(incorrectAnswers.isEmpty)
      String.format(correctFormat, numberOfCorrectAnswers.toString)
    else
      String.format(format, numberOfCorrectAnswers.toString, formattedIncorrectAnswers)
  }
}
