import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {
private String type;
private String fromUsername;
private String toUsername;
private double amount;
private LocalDateTime Date;
private DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

public Transactions(String type, String fromUsername, String toUsername, double amount){
    this.type=type;
    this.fromUsername=fromUsername;
    this.toUsername=toUsername;
    this.amount=amount;
    this.Date=LocalDateTime.now();
}
public void printTransactions(){
    System.out.println(type+" | From "+fromUsername+" |To "+toUsername+" |Amount "+amount+ Date.format(formatter));
}
public String getFromUsername(){
    return fromUsername;
}
public String getToUsername(){
    return toUsername;
}
}

