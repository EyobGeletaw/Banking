import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Client login(String username, String password) {
        for (Client client : clients) {
            if (client.username.equals(username) && client.password.equals(password)) {
                return client;
            }
        }
        return null;
    }

    public Client findClients(String username) {
        for (Client client : clients) {
            if (client.username.equals(username)) {
                return client;
            }
        }
        return null;
    }

    public ArrayList<Client> getClients() {
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
}
}
public void withdraw(String username, double amount) {
        Client client = findClients(username);
        if (client!=null){
            client.getAccount().Withdraw(amount);
            Transactions t = new Transactions("Withdraw",username,"Cash",amount);
            transactions.add(t);
        }
}
public void showClientsTransaction(String username) {
        for (Transactions t : transactions) {
        if (t.getFromUsername().equals(username)||t.getToUsername().equals(username)) {
            t.printTransactions();
        }
        }
}
}
