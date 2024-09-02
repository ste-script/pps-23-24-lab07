package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotRepeatedSpec extends AnyFlatSpec with Matchers {
  "A repeated robot" should "repeat its actions" in:
    val robot = SimpleRobot((0, 0), Direction.North)
    val repeatedRobot = RobotRepeated(robot)
    repeatedRobot.act(2)
    repeatedRobot.position should be((0, 2))

  "A repeated robot" should "not repeat"  in:
    val robot = SimpleRobot((0, 0), Direction.North)
    val repeatedRobot = RobotRepeated(robot)
    repeatedRobot.act(0)
    repeatedRobot.position should be((0, 0))
}
