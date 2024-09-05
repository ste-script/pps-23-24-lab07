package ex3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolitaireSpec extends AnyFlatSpec with Matchers {
  "render" should "return a string representation of the solution" in:
    val solution = Seq((0, 0), (2, 1))
    val width = 3
    val height = 3
    val expected = 2
    Solitaire.render(solution, width, height).contains(expected.toChar)


  "solitaire apply" should "return a rendered board" in:
    Solitaire(5)
}
