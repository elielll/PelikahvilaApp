package reservation.system;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Reservations extends AppCompatActivity implements View.OnClickListener {


    private FirebaseUser user;
    private DatabaseReference referenceTable;
    private String userID;

    private Button removeBtn;

    private String childID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();

        referenceTable = FirebaseDatabase.getInstance().getReference("Tables");

        final TextView dateText = (TextView) findViewById(R.id.date);
        final TextView timeText = (TextView) findViewById(R.id.time);
        final TextView tableText = (TextView) findViewById(R.id.table);

        removeBtn = (Button) findViewById(R.id.removeButton);
        removeBtn.setOnClickListener(this);

        referenceTable.orderByChild(userID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Table user = snapshot.getValue(Table.class);
                childID = snapshot.getKey();

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
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Table user = snapshot.getValue(Table.class);
                childID = snapshot.getKey();

                String date = user.date;
                String time = user.time;
                String table = user.table;

                dateText.setText(date);
                timeText.setText(time);
                tableText.setText(table);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });


    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase.getInstance().getReference("Tables").child(childID).removeValue();
        Toast.makeText(Reservations.this, "Reservation cancelled!", Toast.LENGTH_LONG).show();
    }
}