import java.util.ArrayList;
public class Bank {
    private ArrayList<Client> clients = new ArrayList<>();
    public void addClient(Client client){
        clients.add(client);
    }
    public void removeClient(Client client){
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
    public ArrayList<Client> getClients(){
        return clients;
    }
     public void TransferMoney(Client from, Client to, double amount) {
        for (Client client : clients) {
            if (client.username.equals(from.username) && client.password.equals(from.password)) {
                if (client.getAccount().getBalance() >= amount) {
                    to.getAccount().Deposit(amount);
                    from.getAccount().Withdraw(amount);
                } else () {
                    System.out.println("you dont have enough balance to transfer the money");
                }
            } else () {
                System.out.println("incorrect username or password between accounts");
            }
        }
    }
}
