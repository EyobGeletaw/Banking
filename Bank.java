import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private HashMap<String,Client> clients = new HashMap<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    public void addClient(String username,Client client) {
        clients.put(username,client)
    }

    public void removeClient(String username) {
        clients.remove(username);
    }
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public Client login(String username, String password) {
        for (Client client : clients.values()) {
            if (client.username.equals(username) && client.password.equals(password)) {
                return client;
            }
        }
        return null;
    }
    public Admin loginAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.username.equals(username) && admin.password.equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public Client findClients(String username) {
        for (Client client : clients.values()) {
            if (client.username.equals(username)) {
                return client;
            }
        }
        return null;
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

    public void TransferMoney(String from, String to, double amount) {
        Client senderClient = findClients(from);
        Client rceiverClient = findClients(to);
        if (senderClient == null) {
            System.out.println("sender client doesn't exist");
        }
        if (rceiverClient == null) {
            System.out.println("rceiver client doesn't exist");
        }
        Account senderAccount= senderClient.getAccount();
        Account rceiverAccount= rceiverClient.getAccount();
        if (senderAccount.getBalance()>amount){
            senderAccount.Withdraw(amount);
            rceiverAccount.Deposit(amount);
            System.out.println("Transfer successful");
            Transactions t= new Transactions("Transfer",from,to,amount);
            transactions.add(t);
            senderClient.updateCreditScore(from,amount*0.05);
        }
        else{
            System.out.println("Transfer failed insufficient balance");
    }
}
public ArrayList<Transactions> transactions = new  ArrayList<>();
    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }
public void deposit(String username, double amount) {
        Client client = findClients(username);
        if (client!=null){
            client.getAccount().Deposit(amount);
            Transactions t = new Transactions("Deposit","Cash",username,amount);
            transactions.add(t);
            totalBankBalance+=amount;
            client.updateCreditScore(username,amount*0.05);

}
}
public void withdraw(String username, double amount) {
        Client client = findClients(username);
        if (client!=null){
            client.getAccount().Withdraw(amount);
            Transactions t = new Transactions("Withdraw",username,"Cash",amount);
            transactions.add(t);
            totalBankBalance-=amount;
            client.updateCreditScore(username,amount*0.03);
        }

}

public void showClientsTransaction(String username) {
        for (Transactions t : transactions) {
        if (t.getFromUsername().equals(username)||t.getToUsername().equals(username)) {
            t.printTransactions();
        }
        }
}
private Integer numberOfClientTransaction;
public Integer numberOfTransactions(String username) {
        for(Transactions t : transactions){
            if (t.getFromUsername().equals(username)||t.getToUsername().equals(username)) {
                numberOfClientTransaction++;

            }
        }
        return numberOfClientTransaction;
}
public Double totalBankBalance;
public Double bankBalance(){
    return totalBankBalance;
}
public Double totalAvailableLoan=totalBankBalance/2;
public  Double bankAvailableLoan(){
    return totalAvailableLoan;
}

public ArrayList<Loan> listOfTotalAppliedLoans =new ArrayList<>();
public void addAppliedLoans(Loan loan) {
    listOfTotalAppliedLoans.add(loan);
}
public ArrayList<Loan> getListOfTotalLoansLoans() {
    return listOfTotalAppliedLoans;
}
public Loan getLoan(String username) {
    for (Loan loan : listOfTotalAppliedLoans) {
        if (loan.getUsername().equals(username)) {
            return loan;
        }
    }
    return null;
}
public ArrayList<Loan> activeLoans =new ArrayList<>();
public ArrayList<Loan> getActiveLoans(){
    return activeLoans;
}
public boolean findactiveLoans(String username) {
    for(Loan loan2 :getActiveLoans()){
        if (username.equals(loan2.getUsername())){
            return true;
        }
        else{
            return false;
        }
    }
    return false;
}
public Loan getActiveLoan(String username) {
    for (Loan loan2 : getActiveLoans()){
        if (username.equals(loan2.getUsername())){
            return loan2;
        }
    }
    return null;
}

public ArrayList<Loan> rejectedLoans =new ArrayList<>();
public ArrayList<Loan> getRejectedLoans(){
    return rejectedLoans;
}
public Loan getTheLoan(String username) {
    for (Loan loan : listOfTotalAppliedLoans) {
        if (loan.getUsername().equals(username)) {
            return loan;
        }
    }
    return null;
}

public boolean eligibleLoan(Loan loan) {
    Client client = findClients(loan.getUsername());
    if (client!=null){
        if (client.eligibleLoanAmount()>=loan.getAmount()&bankAvailableLoan()>=loan.getAmount()){
            return true;
        }
        else{
            return false;
        }
    }
    return false;
}
public void Accept_Reject_Loan(Loan loan) {
    if (getTheLoan(loan.getUsername()) != null) {
        if (eligibleLoan(loan)) {
            System.out.println("Loan Accepted");
            activeLoans.add(loan);
            DepositLoan(loan);
        } else {
            System.out.println("Loan Rejected");
            rejectedLoans.add(loan);
        }
    }
}
public void DepositLoan(Loan loan) {
    findClients(loan.getUsername()).getAccount().addacceptedloantoaccount(loan.getAmount());
    totalBankBalance-=loan.getAmount();
}
public void repayLoan(Loan loan) {
    findClients(loan.getUsername()).getAccount().payrecievedloanfromaccount(loan.getAmount());
    totalBankBalance+=loan.getAmount();
    activeLoans.remove(loan);
}
public void statusOfLoan(String username) {
    if (findactiveLoans(username)){
    System.out.println("Loan Accepted");
    }
    else if (username.equals(getTheLoan(username).getUsername())){
        System.out.println("Loan Pending");
    }
    else{
        System.out.println("Loan Rejected");
    }
}
}

