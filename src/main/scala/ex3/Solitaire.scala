package ex3

object Solitaire extends App:
  def render(solution: Seq[(Int, Int)], width: Int, height: Int): String =
    val reversed = solution.reverse
    val rows =
      for
        y <- 0 until height
        row = for
          x <- 0 until width
          number = reversed.indexOf((x, y)) + 1
        yield if number > 0 then "%-2d ".format(number) else "X  "
      yield row.mkString
    rows.mkString("\n")

  // println(render(solution = Seq((0, 0), (2, 1)), width = 3, height = 3))

  def apply(size: Int): Unit =
    val board = new Board(size)
    board.init()
    board.right()
    board.up()
    board.left()
    board.render()

  class Board(size: Int = 5):
    private var field = Seq.empty[(Int, Int)]
    def init(): Unit = field = (size / 2, size / 2) +: field
    def render(): Unit =
      println(Solitaire.render(field, size, size))
    def add(x: Int, y: Int): Unit = field = (x, y) +: field
    private def contains(x: Int, y: Int): Boolean = field.contains((x, y))
    def right(): Unit = field = (field.head._1 + 2, field.head._2) +: field
    def left(): Unit = field = (field.head._1 - 2, field.head._2) +: field
    def up(): Unit = field = (field.head._1, field.head._2 - 2) +: field
    def down(): Unit = field = (field.head._1, field.head._2 + 2) +: field
    def isValid(x: Int, y: Int): Boolean =
      !this.contains(x, y) && x < size && y < size && x > 0 && y > 0

