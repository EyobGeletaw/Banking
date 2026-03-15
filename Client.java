import java.util.Scanner;

public class Client extends User {
    private Account account;
    private Bank bank;
    private String AccountNumber;
    public Client(String Name, String username , String Password,String AccountNumber,Bank bank) {
        super(Name,username,Password);
        this.account = new Account(AccountNumber);
        this.bank = bank;
        this.AccountNumber=AccountNumber;
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
    Scanner input = new Scanner(System.in);
    public void showMenu() {
        System.out.println("1.Check Balance");
        System.out.println("2. Money");
        System.out.println("3.See Recent Transactions");
        System.out.println("4.Exit");
        Integer choice=input.nextInt();
        do {
            switch (choice) {
                case 1:
                    account.getBalance();
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
                    System.out.println("Exit Program");
                    break;
            }
        }while(choice!=4);
    }
}

