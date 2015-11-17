package name.mikulskibartosz.funwithscala.oo

import name.mikulskibartosz.funwithscala.oo.io.{InputReader, OutputWriter}
import name.mikulskibartosz.funwithscala.oo.questions.{Answer, Question, QuestionRepository}

/**
 * Displays n questions, collects the answers and shows the result.
 */
class Flashcards(
                  val inputReader: InputReader,
                  val outputWriter: OutputWriter,
                  val questionFormatter: (Question) => String,
                  val resultFormatter: (Int, List[Answer]) => String,
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
    ) yield askQuestion(question)

    val numberOfCorrectAnswers = answers.count(_.isCorrect)
    val incorrectAnswers = answers.filter(a => !a.isCorrect)
    val formattedResult = resultFormatter(numberOfCorrectAnswers, incorrectAnswers)
    outputWriter.writeLine(formattedResult)
  }

  /**
   * Prints the formatted question and returns the answer.
   *
   * @param question the question
   * @return the user's answer
   */
  private def askQuestion(question: Question) = {
    val formattedQuestion = questionFormatter(question)
    val answer = askQuestion(formattedQuestion)
    Answer(question, answer)
  }

  /**
   * Prints the question and returns the answer.
   *
   * @param question the question
   * @return the user's answer
   */
  private def askQuestion(question: String) = {
    outputWriter.writeLine(question)
    inputReader.readLine
  }
}
