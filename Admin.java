import java.sql.SQLOutput;
import java.util.Scanner;

public class Admin extends User {
    private Bank bank;
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
            System.out.println("5. Exit");
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
                    String account = input.nextInt();
                    Client client = new  Client(name,username,password,account);
                    bank.addClient(client);
                    System.out.println("client has been created");
                    break;
                case 2:
                    input.nextLine();
                    
            }
        }do
    }
}

