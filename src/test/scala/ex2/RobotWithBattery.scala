package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotWithBatterySpec extends AnyFlatSpec with Matchers {
  "A robot that has battery level" should "decrement its battery" in:
    val robot = RobotWithBattery(SimpleRobot((0, 0), Direction.North))
    robot.act(5)
    robot.battery should be(95)

  "A discharged robot" should "not move" in:
    val robot = RobotWithBattery(SimpleRobot((0, 0), Direction.North))
    robot.turn(Direction.East)
    robot.act(51)
    robot.direction should be(Direction.East)
    robot.battery should be(49)
    robot.position should be((1, 0))
    robot.turn(Direction.South)
    robot.act(51)
    robot.battery should be(49)
    robot.direction should be(Direction.South)
    robot.position should be((1, 0))

  "A failable robot" should "fail" in:
    val robot = RobotCanFail(SimpleRobot((0, 0), Direction.North))
    robot.turn(Direction.East)
    robot.act(100)
    robot.direction should be(Direction.East)
    robot.position should be((0, 0))
    robot.act(0)
    robot.position should be((1, 0))
}
