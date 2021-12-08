package reservation.system;

import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;

public class User {
    public String fullName, email;
    public String date, time;
    public String table;
    //public FirebaseUser name;

    //tämä tyhjä konstruktori pitää säilyttää täällä
    public User()
    {

    }

    //konstruktori varaustietojen tallettamista varten firebaseen
    public User(String date,String time, String table)
    {
        this.date=date;
        this.time=time;
        this.table=table;
    }

    public User(String fullName, String email)
    {
        this.email=email;
        this.fullName=fullName;
    }
}
