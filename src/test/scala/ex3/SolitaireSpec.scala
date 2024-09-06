package ex3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Solitaire.*

class SolitaireSpec extends AnyFlatSpec with Matchers {
  "render" should "return a string representation of the solution" in:
    val solution = Seq((0, 0), (2, 1))
    val width = 3
    val height = 3
    val expected = 2
    Solitaire.render(solution, width, height).contains(expected.toChar)

  "test positions" should "fail if too near" in:
    val board = new Board(5)
    board.init()
    assert(board.isValid(4, 2))
    assert(!board.isValid(3, 2))
    assert(!board.isValid(2, 2))
    assert(!board.isValid(1, 0))
    assert(!board.isValid(2, 1))
    assert(!board.isValid(2, 8))

    assert(board.isValid(2, 4))
    assert(board.isValid(3, 3))
    assert(board.isValid(1, 1))

  "test wtf" should "fail if too near" in:
    val board = new Board(7,5)
    board.field = List((1,0),(0,1), (0,3), (1,4), (1,2), (2,1), (2,3), (3,2))
    board.render()
    assert(board.isHorizontalValid((3, 0)))
    assert(board.isValid((3, 0)))
}
