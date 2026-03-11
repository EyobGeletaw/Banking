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
            Client senderClient = findClients(from);
        Client rceiverClient = findClients(to);
        if (senderClient == null) {
            System.out.println("sender client doesn't exist");
        }
     if (rceiverClient == null) {
            System.out.println("rceiver client doesn't exist");
        }
    }
}
