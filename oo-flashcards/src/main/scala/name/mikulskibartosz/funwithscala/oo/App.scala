package name.mikulskibartosz.funwithscala.oo

import name.mikulskibartosz.funwithscala.oo.formatters.{QuestionFormatter, ResultFormatter}
import name.mikulskibartosz.funwithscala.oo.io.{ConsoleReader, ConsoleWriter}
import name.mikulskibartosz.funwithscala.oo.questions.InMemoryQuestionRepository

object App {
  def main(args: Array[String]) = {
    val flashcards = new Flashcards(
      new ConsoleReader(),
      new ConsoleWriter(),
      new QuestionFormatter(),
      new ResultFormatter(),
      new InMemoryQuestionRepository())

    flashcards.run(5)
  }
}
