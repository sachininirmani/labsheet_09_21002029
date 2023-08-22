class RationalNumber1(n: Int, d: Int) {
  require(d != 0, "Denominator must be nonzero")

  private val gcdValue = gcd(this.n, this.d)
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: RationalNumber1 = new RationalNumber1(-numerator, denominator)

  override def toString: String = s"$numerator / $denominator"

}

object RationalNumberQ01 {
  def main(args: Array[String]): Unit = {
    val x = new RationalNumber1(2, 3)
    val y = x.neg

    println(s"x: $x")
    println(s"Negative of x: $y")
  }
}
