package reservation.system;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Appointment extends AppCompatActivity implements View.OnClickListener{
        private Button btn1,btn2,btn3;
        EditText etDate;
        EditText etTime;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_appointment);

            btn1 = (Button) findViewById(R.id.button26);
            btn1.setOnClickListener(this);

            btn2 = (Button) findViewById(R.id.button27);
            btn2.setOnClickListener(this);

            btn3 = (Button) findViewById(R.id.button28);
            btn3.setOnClickListener(this);

            etDate = findViewById(R.id.et_date);
            etTime = findViewById(R.id.et_time);

            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            final int hour = calendar.get(Calendar.HOUR);
            final int minute = calendar.get(Calendar.MINUTE);

            etDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            Appointment.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            month = month + 1;
                            String date = day + "/" + month + "/" + year;
                            etDate.setText(date);
                        }
                    }, year, month, day);
                    datePickerDialog.show();
                }
            });


            etTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(
                            Appointment.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hour, int minute) {
                            String time = hour + ":" + minute;
                            etTime.setText(time);
                        }
                    }, hour, minute, true);
                    timePickerDialog.show();
                }
            });

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.button26:
                    if(btn1.isSelected()) {

                        btn1.setSelected(false);
                    }
                    else{
                        btn1.setSelected(true);
                    }
                    break;

                case R.id.button27:
                    if(btn2.isSelected()) {

                        btn2.setSelected(false);
                    }
                    else{
                        btn2.setSelected(true);
                    }
                    break;

                case R.id.button28:
                    if(btn3.isSelected()) {

                        btn3.setSelected(false);
                    }
                    else{
                        btn3.setSelected(true);
                    }
                    break;

            }
        }
    public void Reserve(View view){
        if(btn1.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").child(FirebaseAuth.getInstance()
                    .getCurrentUser().getUid()).setValue(btn1.getText());
            Toast.makeText(Appointment.this, "Table 1 Reserved!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Appointment.this, "Select a table", Toast.LENGTH_LONG).show();
        }
    }
}

