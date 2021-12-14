package reservation.system;

import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;

public class User {
    public String fullName, email;

    //tämä tyhjä konstruktori pitää säilyttää täällä
    public User()
    {

    }


    public User(String fullName, String email)
    {
        this.email=email;
        this.fullName=fullName;
    }
}
