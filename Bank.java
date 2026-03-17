import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private HashMap<String,Client> clients = new HashMap<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    public void addClient(String username,Client client) {
        clients.put(username,client);
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
}
}
public void withdraw(String username, double amount) {
        Client client = findClients(username);
        if (client!=null){
            client.getAccount().Withdraw(amount);
            Transactions t = new Transactions("Withdraw",username,"Cash",amount);
            transactions.add(t);
            totalBankBalance-=amount;
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
public ArrayList<Loan> listOfLoans =new ArrayList<>();
public void addLoan(Loan loan) {
    listOfLoans.add(loan);
}
public ArrayList<Loan> getLoans() {
    return listOfLoans;
}
public ArrayList<Loan> activeLoans =new ArrayList<>();
public ArrayList<Loan> getActiveLoans() {
    for(Loan loan : listOfLoans){
        if (loan.getStatus()=="Accepted"){
            activeLoans.add(loan);
        }
    }
    return activeLoans;
}
}
