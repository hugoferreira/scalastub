import org.specs2.mutable._
import org.specs2.ScalaCheck
import org.scalacheck.Arbitrary._
import org.scalacheck._
import Prop._

class HelloWorldSpec extends Specification with ScalaCheck {
  "Summing nuymbers" should {
    "satisfy commutativity" ! check {
      forAll { (i: Int, j: Int) => i + j == j + i }
    }

    "satisfy associativity" ! check {
      forAll { (i: Int, j: Int, k: Int) => (i + j) + k == i + (j + k) }
    }

    "sanity check" ! check {
      forAll { (i: Int, j: Int) => i + j == i * j }
    }
  }
}