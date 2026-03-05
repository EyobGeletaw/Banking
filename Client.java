public class Client extends User {
    String Accountnumber;
    public Client(String Name, String Username , String Password,String Accountnumber) {
        super(Name,Username,Password);
        this.Accountnumber=Accountnumber;
    }
    public void showinformation() {
        super.showinformation();
        System.out.println("Account Number: "+Accountnumber);
    }
}
