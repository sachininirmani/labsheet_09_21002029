class RationalNumber2(n: Int, d: Int) {
  require(d != 0, "Denominator must be nonzero")

  private val gcdValue = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: RationalNumber2 = new RationalNumber2(-numerator, denominator)

  def sub(other: RationalNumber2): RationalNumber2 =
    new RationalNumber2(numerator * other.denominator - other.numerator * denominator, denominator * other.denominator)

  override def toString: String = s"$numerator / $denominator"
}

object RationalNumberQ02 {
  def main(args: Array[String]): Unit = {
    val x = new RationalNumber2(3, 4)
    val y = new RationalNumber2(5, 8)
    val z = new RationalNumber2(2, 7)

    val result = x.sub(y).sub(z)

    println(s"x: $x")
    println(s"y: $y")
    println(s"z: $z")
    println(s"Result of x - y - z: $result")
  }
}
