import java.time.LocalDateTime

public class Loan {
    String username;
    String status;
    public Loan(String username,double amount,String status ){
        this.username=username;
        this.status=status;
    }
public String getStatus(){
        return status;
}
}

