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
            System.out.println("----show menu for banking purposes-----");
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
                    String account = input.nextLine();
                    Client client = new  Client(name,username,password,account);
                    bank.addClient(client);
                    System.out.println("client has been created");
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("client username:");
                    String userDepotsit =input.nextLine();
                    Client c1 = bank.findClients(userDepotsit);
                    if(c1!=null){
                        System.out.println("enter the amount please");
                        double amount = input.nextDouble();
                        c1.getAccount().Deposit(amount);
                        System.out.println("client has been deposited the balance is"+ c1.getAccount().getBalance());
                    }
                    else{
                        System.out.println("This client doesn't exist");
                        break;
                    }
                case 3:
                    input.nextLine();
                    System.out.println("client username:");
                    String userWithdraw =input.nextLine();
                    Client c2 = bank.findClients(userWithdraw);
                    if (c2!=null ){
                    System.out.println("enter the amount please");
                    double amount = input.nextDouble();
                    c2.getAccount().Withdraw(amount);
                        System.out.println("client has been withdrawed"+ amount +  "now the balance is"+ c2.getAccount().getBalance());
                    }
                    else{
                        System.out.println("this client doesn't exist");
                        break;
                    }

            case 4:
            input.nextLine();
            for (Client c : bank.getClients()) {
                System.out.println(c.getUsername()+c.getAccount()+"balance is"+ c.getAccount().getBalance());}
            break;
            default:
                System.out.println("Invalid choice" );;
                break;
            }
    } while(choice!=5);
}
}


