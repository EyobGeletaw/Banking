import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
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
        Client Loggedin =bank.login(username,password);
        if (Loggedin!=null){
            System.out.println("Welcome you logged in successfully " + Loggedin.getUsername());
            Loggedin.showMenu();
        }
        else{
            System.out.println("Invalid username or password");
        }
    }  if (Loggedin!=null){
            System.out.println("Welcome you logged in successfully " + Loggedin.getUsername());
            Loggedin.showMenu();
        }
}
