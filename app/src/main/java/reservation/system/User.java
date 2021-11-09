package reservation.system;

public class User {
    public String name, email, password;

    public User()
    {

    }

    public User(String name, String email)
    {
        this.email=email;
        this.name=name;
    }
}
