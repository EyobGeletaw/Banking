import java.util.Scanner;

public class Client extends User {
    private Account account;
    public Client(String Name, String Username , String Password,String AccountNumber) {
        super(Name,Username,Password);
        this.account = new Account(AccountNumber);
    }
    public void showinformation() {
        super.showinformation();
        System.out.println("Account Number: "+ account );

    }
    public void Showmenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. To Deposit");
            System.out.println("2.To Withdraw");
            System.out.println("3. To Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Amount Number");
                    double depositamount = input.nextDouble();
                    account.Deposit(depositamount);
                    break;
                case 2:
                    System.out.println("Enter Amount Number");
                    double withdrawamount = input.nextDouble();
                    account.Withdraw(withdrawamount);
                    break;
                case 3:
                    System.out.println("Your Balance is" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }while (choice!=4);
    }
}
