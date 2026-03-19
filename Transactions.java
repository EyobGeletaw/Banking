public class Transactions {
private String type;
private String fromUsername;
private String toUsername;
private double amount;
public Transactions(String type, String fromUsername, String toUsername, double amount){
    this.type=type;
    this.fromUsername=fromUsername;
    this.toUsername=toUsername;
    this.amount=amount;
}
public void printTransactions(){
    System.out.println(type+" | From "+fromUsername+" |To "+toUsername+" |Amount "+amount);
}
public String getFromUsername(){
    return fromUsername;
}
public String getToUsername(){
    return toUsername;
}
}

