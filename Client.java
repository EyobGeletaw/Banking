
public class Client extends User {
    private Account account;
    private Bank bank;
    private String AccountNumber;
    private Double creditScore;
    public Client(String Name, String username , String Password,String AccountNumber,Bank bank) {
        super(Name,username,Password);
        this.account = new Account(AccountNumber);
        this.bank = bank;
        this.creditScore=20.0;
    }
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Account Number: "+ account );
    }
    public Double seeBalance(Account account) {
        return account.getBalance();
    }
    public Account  getAccount() {
        return account;
    }
    public void updateCreditScore(String username, double amount){
        this.creditScore=this.creditScore+amount;
    }

    public Double eligibleLoanAmount() {
        if (this.creditScore >= 10) {
            System.out.println(this.creditScore);
            return this.account.getBalance() * this.creditScore/100;
        }
        else{
            System.out.println("You are not Eligible for credit access");
            return 0.0;

        }
    }
    Scanner input = new Scanner(System.in);
    public void showMenu() {
        int choice;
        do {
            System.out.println("1.Check Balance");
            System.out.println("2.Transfer Money");
            System.out.println("3.See Recent Transactions");
            System.out.println("4.Apply for Loan");
            System.out.println("5.Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    account.showBalance();
                    break;
                case 2:
                    System.out.println("Enter username that you want to transfer to");
                    String usernameto = input.next();
                    System.out.println("Enter the amount you want to transfer");
                    double amount = input.nextDouble();
                    bank.TransferMoney(this.username, usernameto, amount);
                    break;
                case 3:
                    bank.showClientsTransaction(this.username);
                case 4:
                    showLoanMenu();
                case 5:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("You have entered invalid choice");
            }
        }while(choice!=5);
    }
    public void showLoanMenu(){
        int choice;
        do {
            System.out.println("1,To apply to Loan");
        System.out.println("2. To see the result of the Applied Loan");
        System.out.println("3. To pay received loan");
        System.out.println("4.To Back to menu");
        choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter how much money do you want");
                    Double money = input.nextDouble();
                    Loan l = new Loan(this.username, money);
                    bank.addAppliedLoans(l);
                    System.out.println("You have successfully applied please Wait for the results carefully");
                    break;
                case 2:
                    bank.statusOfLoan(this.username);
                    System.out.println();
                    break;
                case 3:
                    bank.repayLoan(bank.getActiveLoan(this.username));
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("You have entered invalid choice");
            }
        } while (choice != 4);
    }
}

