class Account1(private var balance: Double) {
  def getBalance1: Double = balance

  def deposit1(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Deposit amount should be greater than zero.")
    }
  }

  def withdraw1(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else if (amount <= 0) {
      println("Withdraw amount should be greater than zero.")
    } else {
      println("Insufficient balance.")
    }
  }

  def transfer1(amount: Double, targetAccount: Account1): Unit = {
    if (amount > 0 && amount <= balance) {
      withdraw1(amount)
      targetAccount.deposit1(amount)
      println(s"Transferred $amount to target account.")
    } else if (amount <= 0) {
      println("Transfer amount should be greater than zero.")
    } else {
      println("Insufficient balance for transfer.")
    }
  }
}

object AccountDemoQ03 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account1(1000.0)
    val account2 = new Account1(500.0)

    println("Account 1 balance: " + account1.getBalance1)
    println("Account 2 balance: " + account2.getBalance1)

    account1.deposit1(200.0)
    account1.withdraw1(150.0)
    account1.transfer1(100.0, account2)

    println("Account 1 balance: " + account1.getBalance1)
    println("Account 2 balance: " + account2.getBalance1)
  }
}
