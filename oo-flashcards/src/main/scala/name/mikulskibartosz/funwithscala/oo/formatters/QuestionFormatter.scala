package name.mikulskibartosz.funwithscala.oo.formatters

import name.mikulskibartosz.funwithscala.oo.questions.Question

/**
 * Formats a questions. Returns it in the following format: "> translate: {question}"
 */
class QuestionFormatter {
  /**
   * The format of a question.
   */
  private val lineFormat = "> translate %s"

  /**
   * Formats a questions. Returns it in the following format: "> translate: {question}"
   *
   * @param question the question
   * @return the formatted question
   */
  def format(question: Question) = String.format(lineFormat, question.question)
}
