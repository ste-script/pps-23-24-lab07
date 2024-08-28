package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotWithBatterySpec extends AnyFlatSpec with Matchers {
  "A robot that has battery level" should "decrement its battery" in:
    val robot = RobotWithBattery(SimpleRobot((0, 0), Direction.North), 5)
    robot.act()
    robot.battery should be(95)

  "A discharged robot" should "not move" in:
    val robot = RobotWithBattery(SimpleRobot((0, 0), Direction.North), 51)
    robot.turn(Direction.East)
    robot.act()
    robot.direction should be(Direction.East)
    robot.battery should be(49)
    robot.position should be ((1,0))
    robot.turn(Direction.South)
    robot.act()
    robot.battery should be(49)
    robot.direction should be(Direction.South)
    robot.position should be ((1, 0))
}
