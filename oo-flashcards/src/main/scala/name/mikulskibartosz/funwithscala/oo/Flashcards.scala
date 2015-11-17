package name.mikulskibartosz.funwithscala.oo

import name.mikulskibartosz.funwithscala.oo.io.{InputReader, OutputWriter}
import name.mikulskibartosz.funwithscala.oo.questions.{Answer, Question, QuestionRepository}

import scalaz.effect.IO

/**
 * Displays n questions, collects the answers and shows the result.
 */
class Flashcards(
                  val inputReader: InputReader,
                  val outputWriter: OutputWriter,
                  val formatQuestion: (Question) => String,
                  val formatResult: (Int, List[Answer]) => String,
                  val questionRepository: QuestionRepository) {
  /**
   * Displays n questions, collects the answers and shows the result.
   *
   * @param numberOfQuestions the number of questions to be displayed
   */
  def run(numberOfQuestions: Int) = {
    IO {
      questionRepository.get(numberOfQuestions) //TODO remove parameter
    }.map(for (question <- _) yield askQuestion(question))
      .map(answers => {
      answers.count(_.isCorrect) -> answers.filter(a => !a.isCorrect)
    }).map {
      case (correctNo, incorrect) => formatResult(correctNo, incorrect)
    }.flatMap(
        result => IO[Unit] {
          outputWriter.writeLine(result)
        }
      ).unsafePerformIO()
  }

  /**
   * Prints the formatted question and returns the answer.
   *
   * @param question the question
   * @return the user's answer
   */
  private def askQuestion(question: Question): Answer = {
    val formattedQuestion = formatQuestion(question)
    IO{
      outputWriter.writeLine(formattedQuestion)
      inputReader.readLine
    }
    .map(Answer(question, _))
    .unsafePerformIO()
  }
}
