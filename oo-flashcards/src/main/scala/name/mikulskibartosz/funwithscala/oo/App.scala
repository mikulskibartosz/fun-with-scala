package name.mikulskibartosz.funwithscala.oo

import name.mikulskibartosz.funwithscala.oo.formatters.{FormatQuestion, FormatResult}
import name.mikulskibartosz.funwithscala.oo.io.{ConsoleReader, ConsoleWriter}
import name.mikulskibartosz.funwithscala.oo.questions.InMemoryQuestionRepository

object App {
  def main(args: Array[String]) = {
    val flashcards = new Flashcards(
      new ConsoleReader(),
      new ConsoleWriter(),
      FormatQuestion.apply,
      FormatResult.apply,
      new InMemoryQuestionRepository())

    flashcards.run(5)
  }
}
