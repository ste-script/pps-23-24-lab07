package ex3

import scala.collection.immutable.ArraySeq

object Solitaire extends App:
  type Position = (Int, Int)
  def render(solution: Iterable[Position], width: Int, height: Int): String =
    val reversed = solution.toSeq.reverse
    val rows =
      for
        y <- 0 until height
        row = for
          x <- 0 until width
          number = reversed.indexOf((x, y)) + 1
        yield if number > 0 then "%-2d ".format(number) else "X  "
      yield row.mkString
    rows.mkString("\n")

  def init(x: Int, y: Int): Iterable[Position] = Seq((x / 2, y / 2))

  def contains(position: Position, field: Iterable[Position]): Boolean =
    field.toSeq.contains((position._1, position._2))

  def isValid(
      col: Int,
      row: Int,
      pos: Position,
      field: Iterable[Position]
  ): Boolean =
    val x = pos._1
    val y = pos._2
    !contains(pos, field) &&
    x >= 0 && y >= 0 && x < col && y < row

  def renderAll(solutions: Iterable[Iterable[Position]]): Unit =
    solutions.foreach(s => println(render(s, 7, 5) + "\n\n"))
    println(solutions.size)
    println(solutions.getClass)
    println(solutions.head.getClass)

  def getAttempt(pos: Position): Iterable[Position] =
    val x = pos._1
    val y = pos._2
    List(
      (x + 3, y),
      (x - 3, y),
      (x, y + 3),
      (x, y - 3),
      (x + 2, y + 2),
      (x + 2, y - 2),
      (x - 2, y - 2),
      (x - 2, y + 2)
    )

  def placeMarks(
      columns: Int,
      rows: Int,
      field: Iterable[Position],
      remaining: Int = 34
  ): Iterable[Iterable[Position]] =
    remaining match
      case 0 => Iterable(field)
      case _ =>
        for
          solution <- placeMarks(columns, rows, field, remaining - 1)
          pos <- getAttempt(solution.head)
          if isValid(columns, rows, pos, solution)
        yield pos +: solution.toSeq

  renderAll(placeMarks(7, 5, init(7, 5)))
