import java.sql.SQLOutput;
import java.util.Scanner;
public class Admin extends User {
    public Admin(String Name, String Username , String Password, Bank bank)
    {
        super(Name, Username , Password);
        this.bank=bank;
    }
    public void showMenu(){
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----show menu for banking purposes----");
            System.out.println("1. Create Client");
            System.out.println("2.Deposit money");
            System.out.println("3.Withdraw money");
            System.out.println("4.View Clients");
            System.out.println("5.View all Transactions");
            System.out.println("6. Accept or Reject Loan ");
            System.out.println("7. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.println("client name:");
                    String name = input.nextLine();
                    System.out.println("client username:");
                    String username = input.nextLine();
                    System.out.println("client password:");
                    String password = input.nextLine();
                    System.out.println("client Account Number:");
                    String account = input.nextLine();
                    Client client = new  Client(name,username,password,account,bank);
                    bank.addClient(username,client);
                    System.out.println("client has been created");
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("client username:");
                    String userDeposit =input.nextLine();
                    Client c1 = bank.findClients(userDeposit);
                    if(c1!=null){
                        System.out.println("enter the amount please");
                        double amount = input.nextDouble();
                        bank.deposit(userDeposit,amount);
                    }
                    else{
                        System.out.println("this client doesn't exist");
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("client username:");
                    String userWithdraw =input.nextLine();
                    Client c2 = bank.findClients(userWithdraw);
                    if (c2!=null ){
                    System.out.println("enter the amount please");
                    double amount = input.nextDouble();
                    bank.withdraw(userWithdraw,amount);
                    }
                    else{
                        System.out.println("this client doesn't exist");
                        break;
                    }
                case 4:
                    input.nextLine();
                    for (Client c : bank.getClients().values()) {
                        System.out.println(c.getUsername()+ " |"+c.getAccount().getAccountNumber() +"| balance is  "+ c.getAccount().getBalance());
                    }
                    break;
                case 5:
                    showAllTransactions();
                    break;
                case 6:
                    for (Loan loan: bank.getListOfTotalLoansLoans()){
                        bank.Accept_Reject_Loan(loan);
                    }
                    break;
                case 7:
                    System.out.println("exited program");
                    System.exit(0);
                    default:
                        System.out.println("Invalid choice" );;
                        break;
            }
    } while(choice!=7);
}
public void showAllTransactions(){
        for ( Transactions t : bank.getTransactions()){
            t.printTransactions();
        }
}
}


