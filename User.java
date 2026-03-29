public class User {
    protected   String name;
    protected   String username;
    protected   String password;
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    protected void showInformation() {
        System.out.println("Name: " + name);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
    public String getUsername(){
        return username;
    }

    public void showMenu(){
    }
}
