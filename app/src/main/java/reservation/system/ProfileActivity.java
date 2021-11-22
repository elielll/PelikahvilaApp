package reservation.system;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private Button appointment;
    private Button profile;
    private Button reservations;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        appointment = (Button) findViewById(R.id.appointmentID);
        appointment.setOnClickListener(this);

        profile = (Button) findViewById(R.id.profileID);
        profile.setOnClickListener(this);

        reservations = (Button) findViewById(R.id.reservationsID);
        reservations.setOnClickListener(this);

        logout = (Button) findViewById(R.id.signOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profileID:

                break;
            case R.id.appointmentID:
                startActivity(new Intent(this,Appointment.class));
                break;
            case R.id.reservationsID:
                break;
        }
    }
}