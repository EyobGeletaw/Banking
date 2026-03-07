import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients = new ArrayList<>();
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
        
        return null;
    }
}
