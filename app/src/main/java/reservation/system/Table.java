package reservation.system;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Table {

    public String date, time;
    public String table;
    public String userID;

    public Table() {

    }

    public Table(String date,String time, String table, String userID)
    {
        this.date=date;
        this.time=time;
        this.table=table;
        this.userID=userID;
    }
}
