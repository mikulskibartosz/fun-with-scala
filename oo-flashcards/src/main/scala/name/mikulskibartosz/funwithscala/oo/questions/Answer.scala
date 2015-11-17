package name.mikulskibartosz.funwithscala.oo.questions

/**
 * Describes a question and the answer provided by the user.
 */
case class Answer(question: Question, answer: String) {
  val isCorrect = answer == question.correctAnswer
}


