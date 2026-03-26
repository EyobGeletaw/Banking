import java.time.LocalDateTime;

public class Loan {
    String username;
    String status;
    double amount;
    public Loan(String username,double amount ){
        this.amount=amount;
        this.username=username;
        this.status="PENDING";
    }
public String getStatus(){
        return status;
}
public String getUsername(){
        return username;
}
public double getAmount(){
        return this.amount;
}
public void setStatus(String status){
        this.status=status;
}
}
