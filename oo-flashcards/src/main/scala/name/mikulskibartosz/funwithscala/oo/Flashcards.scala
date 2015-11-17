package name.mikulskibartosz.funwithscala.oo

import name.mikulskibartosz.funwithscala.oo.formatters.{QuestionFormatter, ResultFormatter}
import name.mikulskibartosz.funwithscala.oo.io.{InputReader, OutputWriter}
import name.mikulskibartosz.funwithscala.oo.questions.{Answer, QuestionRepository}

/**
 * Displays n questions, collects the answers and shows the result.
 */
class Flashcards(
                  val inputReader: InputReader,
                  val outputWriter: OutputWriter,
                  val questionFormatter: QuestionFormatter,
                  val resultFormatter: ResultFormatter,
                  val questionRepository: QuestionRepository) {
  /**
   * Displays n questions, collects the answers and shows the result.
   *
   * @param numberOfQuestions the number of questions to be displayed
   */
  def run(numberOfQuestions: Int) = {
    val questions = questionRepository.get(numberOfQuestions)

    val answers = for(
      question <- questions;
      formattedQuestion = questionFormatter.format(question);
      unit = outputWriter.writeLine(formattedQuestion);
      answer = inputReader.readLine
    ) yield Answer(question, answer)

    val numberOfCorrectAnswers = answers.count(_.isCorrect)
    val incorrectAnswers = answers.filter(a => !a.isCorrect)
    val formattedResult = resultFormatter.format(numberOfCorrectAnswers, incorrectAnswers)
    outputWriter.writeLine(formattedResult)
  }
}
