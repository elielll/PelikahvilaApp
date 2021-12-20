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
import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Locale;

public class Appointment extends AppCompatActivity implements View.OnClickListener{
        private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn16,btn14,btn15;
        EditText etDate;
        EditText etTime;
        ArrayList<Button> tables = new ArrayList<Button>();

        private FirebaseUser user;
        private DatabaseReference reference;
        private String userID;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_appointment);

            btn1 = (Button) findViewById(R.id.button1);
            btn1.setOnClickListener(this);

            btn2 = (Button) findViewById(R.id.button2);
            btn2.setOnClickListener(this);

            btn3 = (Button) findViewById(R.id.button3);
            btn3.setOnClickListener(this);

            btn4 = (Button) findViewById(R.id.button4);
            btn4.setOnClickListener(this);

            btn5 = (Button) findViewById(R.id.button5);
            btn5.setOnClickListener(this);

            btn6 = (Button) findViewById(R.id.button6);
            btn6.setOnClickListener(this);

            btn7 = (Button) findViewById(R.id.button7);
            btn7.setOnClickListener(this);

            btn8 = (Button) findViewById(R.id.button8);
            btn8.setOnClickListener(this);

            btn9 = (Button) findViewById(R.id.button9);
            btn9.setOnClickListener(this);

            btn10 = (Button) findViewById(R.id.button10);
            btn10.setOnClickListener(this);

            btn11 = (Button) findViewById(R.id.button11);
            btn11.setOnClickListener(this);

            btn12 = (Button) findViewById(R.id.button12);
            btn12.setOnClickListener(this);

            btn16 = (Button) findViewById(R.id.button16);
            btn16.setOnClickListener(this);

            btn14 = (Button) findViewById(R.id.button14);
            btn14.setOnClickListener(this);

            btn15 = (Button) findViewById(R.id.button15);
            btn15.setOnClickListener(this);

            etDate = findViewById(R.id.et_date);
            etTime = findViewById(R.id.et_time);

            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            final int hour = calendar.get(Calendar.HOUR_OF_DAY);
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
                            String time = hour+":"+minute;
                            etTime.setText(String.format(Locale.getDefault(), "%02d:%02d", hour,minute));
                        }
                    }, hour, minute, true);
                    timePickerDialog.show();
                }
            });

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.button1:
                    btn1.setSelected(!btn1.isSelected());
                    break;

                case R.id.button2:
                    btn2.setSelected(!btn2.isSelected());
                    break;

                case R.id.button3:
                    btn3.setSelected(!btn3.isSelected());
                    break;

                case R.id.button4:
                    btn4.setSelected(!btn4.isSelected());
                    break;

                case R.id.button5:
                    btn5.setSelected(!btn5.isSelected());
                    break;

                case R.id.button6:
                    btn6.setSelected(!btn6.isSelected());
                    break;

                case R.id.button7:
                    btn7.setSelected(!btn7.isSelected());
                    break;

                case R.id.button8:
                    btn8.setSelected(!btn8.isSelected());
                    break;

                case R.id.button9:
                    btn9.setSelected(!btn9.isSelected());
                    break;

                case R.id.button10:
                    btn10.setSelected(!btn10.isSelected());
                    break;

                case R.id.button11:
                    btn11.setSelected(!btn11.isSelected());
                    break;

                case R.id.button12:
                    btn12.setSelected(!btn12.isSelected());
                    break;

                case R.id.button16:
                    btn16.setSelected(!btn16.isSelected());
                    break;

                case R.id.button14:
                    btn14.setSelected(!btn14.isSelected());
                    break;

                case R.id.button15:
                    btn15.setSelected(!btn15.isSelected());
                    break;

            }
        }

    public void Reserve(View v){
        //haetaan valitut aika ja päivä muuttujiin
        String time = etTime.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String table;

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        
        if(btn1.isSelected())
        {
            table=btn1.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 1 Varattu!", Toast.LENGTH_LONG).show();
            btn1.setClickable(false); // asetetaan buttoni falseksi ettei sitä voi enää muutta ku varaus tehty
        }

        else if(btn2.isSelected())
        {
            table=btn2.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 2 Varattu!", Toast.LENGTH_LONG).show();
            btn2.setClickable(false);
        }
        else if(btn3.isSelected())
        {
            table=btn3.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 3 Varattu!", Toast.LENGTH_LONG).show();
            btn3.setClickable(false);
        }
        else if(btn4.isSelected())
        {
            table=btn4.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 4 Varattu!", Toast.LENGTH_LONG).show();
            btn4.setClickable(false);
        }
        else if(btn5.isSelected())
        {
            table=btn5.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 5 Varattu!", Toast.LENGTH_LONG).show();
            btn5.setClickable(false);
        }
        else if(btn6.isSelected())
        {
            table=btn6.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 6 Varattu!", Toast.LENGTH_LONG).show();
            btn6.setClickable(false);
        }
        else if(btn7.isSelected())
        {
            table=btn7.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 7 Varattu!", Toast.LENGTH_LONG).show();
            btn7.setClickable(false);
        }
        else if(btn8.isSelected())
        {
            table=btn8.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 8 Varattu!", Toast.LENGTH_LONG).show();
            btn8.setClickable(false);
        }
        else if(btn9.isSelected()) {
            table = btn9.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 9 Varattu!", Toast.LENGTH_LONG).show();
            btn9.setClickable(false);
        }
        else if(btn10.isSelected()) {
            table = btn10.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 10 Varattu!", Toast.LENGTH_LONG).show();
            btn10.setClickable(false);
        }
        else if(btn11.isSelected()) {
            table = btn11.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 11 Varattu!", Toast.LENGTH_LONG).show();
            btn11.setClickable(false);
        }
        else if(btn12.isSelected()) {
            table = btn12.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 12 Varattu!", Toast.LENGTH_LONG).show();
            btn12.setClickable(false);
        }
        else if(btn16.isSelected()) {
            table = btn16.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 1 Varattu!", Toast.LENGTH_LONG).show();
            btn16.setClickable(false);
        }
        else if(btn14.isSelected()) {
            table = btn14.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 2 Varattu!", Toast.LENGTH_LONG).show();
            btn14.setClickable(false);
        }
        else if(btn15.isSelected()) {
            table = btn15.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 3 Varattu!", Toast.LENGTH_LONG).show();
            btn15.setClickable(false);
        }
        else
        {
            Toast.makeText(Appointment.this, "Valitse pöytä!", Toast.LENGTH_LONG).show();
        }

    }


}

