public class Account {
    public String AccountNumber;
    public Double Balance;
    public Account(String AccountNumber) {
        this.AccountNumber=AccountNumber;
        this.Balance=0.0;
    }
}  public void Deposit(double amount) {
        if (amount > 0) {
            Balance = Balance + amount;
            System.out.println("your account has been credited " + amount);
            System.out.println("Your current balance is " + Balance);
        }
        else {
            System.out.println("Invalid amount");
        
      }
}
    
    public void Withdraw(double amount) {
        if (amount > 0 && Balance >= amount) {
            Balance = Balance - amount;
            System.out.println("your account has been debited" + amount);
            System.out.println("Your current balance is " + Balance);
        }
        else {
            System.out.println("Invalid amount or insufficient balance");
        }
    }
    public void addacceptedloantoaccount(Double amount){
        Balance+=amount;
    }
    public void payrecievedloanfromaccount(Double amount){
        Balance-=amount;
    }

}
