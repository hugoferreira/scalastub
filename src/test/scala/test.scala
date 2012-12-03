import org.specs2.mutable._
import org.specs2.ScalaCheck
import org.scalacheck.Arbitrary._
import org.scalacheck._
import Prop._

trait Category[~>[_, _]] {
  def id[α]: α ~> α
  def compose[α, β, γ](f: α ~> β)(g: β ~> γ): α ~> γ
}

trait MatrixOperations {
  def mult(a: Int, b: Int): Int
  def mult(a: Int, b: Long): Long
  def mult(a: String, b: String): String
}

object Category {
  implicit def fCat = new Category[Function1] {
    def id[A] = { x ⇒ x }
    def compose[A, B, C](f: A => B)(g: B => C) = { x ⇒ g(f(x)) }
  }
}

object SkiCombinators {
  def I[α]: α ⇒ α = { a ⇒ a }
  def K[α, β]: α ⇒ (β ⇒ α) = { a ⇒ _ ⇒ a }
  def S[α, β, γ]: α ⇒ (β ⇒ γ) ⇒ ( α ⇒ β ⇒ (α ⇒ γ)) = { a ⇒ f ⇒ { _ ⇒ b ⇒ { _ ⇒ f(b) } } }
}

class HelloWorldSpec extends Specification with ScalaCheck {
  "Summing numbers" should {
    "satisfy commutativity" ! check {
      forAll { (i: Int, j: Int) => i + j == j - i }
    }

    "satisfy associativity" ! check {
      forAll { (i: Int, j: Int, k: Int) => (i + j) + k == i + (j + k) }
    }

    /* "sanity check" ! check {
      forAll { (i: Int, j: Int) => i + j == i * j }
    } */
  }

  "Categories" should {
    import Category._

    val intG  = { (_ : Int) - 5 }
    val intH  = { (_ : Int) + 3 }

    "compose" ! check {
      forAll { (a: Int) => intG(intH(a)) == fCat.compose(intH)(intG)(a) }
    }

    "left identity" ! check {
      forAll { (a: Int) => fCat.compose(fCat.id[Int])(intG)(a) == intG(a) }
    }

    "right identity" ! check {
      forAll { (a: Int) => fCat.compose(intG)(fCat.id)(a) == intG(a) }
    }
  }

  "Combinators" should {
    import SkiCombinators._

    "I" ! check {
      forAll { (a: Int) ⇒ I(a) == a }
    }

    /* "KII" ! check {
      forAll { (a: Int) ⇒ K(I)(I) == I }
    } */
  }
}
