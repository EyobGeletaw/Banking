public class Account {
    private String AccountNumber;
    private Double Balance;
    public Account(String AccountNumber)
        {
        this.AccountNumber=AccountNumber;
        this.Balance=0.0;
        }
        public String getAccountNumber(){
            return AccountNumber;
    }   public double getBalance(){
        return Balance;
    }   public void deposit(double amount) {
        if (amount > 0) {
            Balance = Balance + amount;
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }
        public void Withdraw(double amount) {
            if (amount > 0 && Balance >= amount) {
                Balance = Balance - amount;
                System.out.println("Withdrawn " + amount);
            } else {
                System.out.println("Ivalid amount or insufficient balance");
            }


        }
}
