class Account2(private var balance: Double) {
  def getBalance2: Double = balance

  def deposit2(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Deposit amount should be greater than zero.")
    }
  }

  def withdraw2(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else if (amount <= 0) {
      println("Withdraw amount should be greater than zero.")
    } else {
      println("Insufficient balance.")
    }
  }

  def transfer2(amount: Double, targetAccount: Account2): Unit = {
    if (amount > 0 && amount <= balance) {
      withdraw2(amount)
      targetAccount.deposit2(amount)
      println(s"Transferred $amount to target account.")
    } else if (amount <= 0) {
      println("Transfer amount should be greater than zero.")
    } else {
      println("Insufficient balance for transfer.")
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else if (balance < 0) {
      balance += balance * 0.1
    }
  }
}

object BankDemoQ04 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account2(1000.0)
    val account2 = new Account2(-500.0)
    val account3 = new Account2(200.0)

    val bank: List[Account2] = List(account1, account2, account3)

    println("List of Accounts with negative balances:")
    val negativeBalanceAccounts = bank.filter(account => account.getBalance2 < 0)
    negativeBalanceAccounts.foreach(account => println(s"Account balance: ${account.getBalance2}"))

    val totalBalance = bank.map(_.getBalance2).sum
    println(s"Total balance of all accounts: $totalBalance")

    println("Final balances of all accounts after applying interest:")
    bank.foreach(account => {
      account.applyInterest()
      println(s"Account balance: ${account.getBalance2}")
    })
  }
}
