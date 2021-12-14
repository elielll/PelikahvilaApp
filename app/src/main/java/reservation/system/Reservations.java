package reservation.system;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Reservations extends AppCompatActivity {


    private FirebaseUser user;
    private DatabaseReference referenceUser;
    private DatabaseReference referenceTable;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        user = FirebaseAuth.getInstance().getCurrentUser();
        referenceUser = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        referenceTable = FirebaseDatabase.getInstance().getReference("Tables");

        final TextView dateText = (TextView) findViewById(R.id.date);
        final TextView timeText = (TextView) findViewById(R.id.time);
        final TextView tableText = (TextView) findViewById(R.id.table);

        referenceTable.orderByChild(userID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Table user = snapshot.getValue(Table.class);

                String date = user.date;
                String time = user.time;
                String table = user.table;

                dateText.setText(date);
                timeText.setText(time);
                tableText.setText(table);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });


    }
}