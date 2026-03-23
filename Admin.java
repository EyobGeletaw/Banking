import java.sql.SQLOutput;
import java.util.Scanner;
public class Admin extends User {
    private Bank bank;
    public Admin(String Name, String Username , String Password, Bank bank)
    {
        super(Name, Username , Password);
        this.bank=bank;
    }
  


