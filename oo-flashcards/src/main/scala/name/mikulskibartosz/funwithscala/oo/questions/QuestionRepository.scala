package name.mikulskibartosz.funwithscala.oo.questions

/**
 * A question and the expected answer.
 */
case class Question(question: String, correctAnswer: String) {}

/**
 * Returns a collection of questions.
 */
trait QuestionRepository {
  def get(limit: Int): List[Question]
}

/**
 * An implementation of the QuestionRepository trait that contains a constant list of questions.
 */
class InMemoryQuestionRepository extends QuestionRepository {
  val questions = List(
    Question("sein", "to be"),
    Question("haben", "to have"),
    Question("werden", "to become"),
    Question("können", "can"),
    Question("müssen", "must"),
    Question("wollen", "to want to"),
    Question("mögen", "to like to"),
    Question("machen", "to make/do"),
    Question("sollen", "should"),
    Question("heißen", "to be called"),
    Question("sagen", "to say"),
    Question("gehen", "to go"),
    Question("sehen", "to see"),
    Question("geben", "to give"),
    Question("kommen", "to come"),
    Question("lassen", "to let/allow"),
    Question("finden", "to find"),
    Question("bleiben", "to stay"),
    Question("nehmen", "to take"),
    Question("bringen", "to bring")
  )

  override def get(limit: Int) = questions.take(limit)
}
