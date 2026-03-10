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
   public void showMenu(String Username , String Password, String AccountNumber) {
        System.out.println("1.Check Balance");
        System.out.println("2.Transfer Money");
       System.out.println("3.See Transactioins")
        System.out.println("4.Exit");
        Integer choice=input.nextInt();
        do{
            switch(choice){
            case 1:
                Account account = new Account(AccountNumber);
                account.getBalance();
                break;
                case 2 :
                    System.out.println("Enter username");
                    String Usernameto =input.next();
                    System.out.println("En");
                    String Passwordto =input.next();


            }
        }
    }
}
