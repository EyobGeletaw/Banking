import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Admin admin=new Admin("Eyob","Eyob","12345",bank);
        bank.addAdmin(admin);
        do
        {System.out.println("Welcome to the Bank Application");
        System.out.println("Are you Admin or Client?");
        System.out.println("1.Admin");
        System.out.println("2.Client");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.equals("1")) {
            System.out.println("Enter your username");
            String username = input.nextLine();
            System.out.println("Enter your password");
            String password = input.nextLine();
            if(bank.loginAdmin(username,password)!=null){
                System.out.println("You have successfully logged in as an admin");
                System.out.println(" --------Welcome to the Admin Bank Application-----");
                bank.loginAdmin(username,password).showMenu();
            }
            else{
                System.out.println("You have not logged in invalid credentials");
            }

        }
        else if (answer.equals("2")) {
            System.out.println("Welcome to the Client's Bank Application");
            System.out.println("Enter your username");
            String username = input.nextLine();
            System.out.println("Enter your password");
            String password = input.nextLine();
            if(bank.login(username,password)!=null){
            bank.login(username,password).showMenu();}
            else{
                System.out.println("You have not logged in invalid credentials or you are not exist");
            }
        }
        else{
            System.out.println("Wrong choice please enter only either 1 or 2");
        }
        }while (true);

}}
