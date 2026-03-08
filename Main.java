import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client client1=new Client("Eyob","eyoba","123qw" , "1452");
        client client2=new Client("mann","njh","kjuy","2345")
        bank.addClient(client1);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Bank Account");
        System.out.println("Please enter your username");
        String username = input.nextLine();
        System.out.println("Please enter your password");
        String password = input.nextLine();
        Client Loggedin =bank.login(username,password);
        if (Loggedin!=null){
            System.out.println("Welcome you logged in successfully " + Loggedin.getUsername());
            Loggedin.showMenu();
        }
        else{
            System.out.println("Invalid username or password");
        }
    }
}
