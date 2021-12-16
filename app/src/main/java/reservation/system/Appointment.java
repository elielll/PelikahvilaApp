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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Locale;

public class Appointment extends AppCompatActivity implements View.OnClickListener{
        private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15;
        EditText etDate;
        EditText etTime;

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

            btn13 = (Button) findViewById(R.id.button16);
            btn13.setOnClickListener(this);

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
            //jos keksii jonku paremman ja lyhyemmän keinon tehä tää ni voi tehä, buttoniin 8 asti tehty

            switch (v.getId()){
                case R.id.button1:
                    if(btn1.isSelected()) {

                        btn1.setSelected(false);
                    }
                    else{
                        btn1.setSelected(true);
                    }
                    break;

                case R.id.button2:
                    if(btn2.isSelected()) {

                        btn2.setSelected(false);
                    }
                    else{
                        btn2.setSelected(true);
                    }
                    break;

                case R.id.button3:
                    if(btn3.isSelected()) {

                        btn3.setSelected(false);
                    }
                    else{
                        btn3.setSelected(true);
                    }
                    break;

                case R.id.button4:
                    if(btn4.isSelected()) {

                        btn4.setSelected(false);
                    }
                    else{
                        btn4.setSelected(true);
                    }
                    break;

                case R.id.button5:
                    if(btn5.isSelected()) {

                        btn5.setSelected(false);
                    }
                    else{
                        btn5.setSelected(true);
                    }
                    break;

                case R.id.button6:
                    if(btn6.isSelected()) {

                        btn6.setSelected(false);
                    }
                    else{
                        btn6.setSelected(true);
                    }
                    break;

                case R.id.button7:
                    if(btn7.isSelected()) {

                        btn7.setSelected(false);
                    }
                    else{
                        btn7.setSelected(true);
                    }
                    break;

                case R.id.button8:
                    if(btn8.isSelected()) {

                        btn8.setSelected(false);
                    }
                    else{
                        btn8.setSelected(true);
                    }
                    break;

                case R.id.button9:
                    if(btn9.isSelected()) {

                        btn9.setSelected(false);
                    }
                    else{
                        btn9.setSelected(true);
                    }
                    break;

                case R.id.button10:
                    if(btn10.isSelected()) {

                        btn10.setSelected(false);
                    }
                    else{
                        btn10.setSelected(true);
                    }
                    break;

                case R.id.button11:
                    if(btn11.isSelected()) {

                        btn11.setSelected(false);
                    }
                    else{
                        btn11.setSelected(true);
                    }
                    break;

                case R.id.button12:
                    if(btn12.isSelected()) {

                        btn12.setSelected(false);
                    }
                    else{
                        btn12.setSelected(true);
                    }
                    break;

                case R.id.button13:
                    if(btn13.isSelected()) {

                        btn13.setSelected(false);
                    }
                    else{
                        btn13.setSelected(true);
                    }
                    break;

                case R.id.button14:
                    if(btn14.isSelected()) {

                        btn14.setSelected(false);
                    }
                    else{
                        btn14.setSelected(true);
                    }
                    break;

                case R.id.button15:
                    if(btn15.isSelected()) {

                        btn15.setSelected(false);
                    }
                    else{
                        btn15.setSelected(true);
                    }
                    break;

            }
        }
        // varaus nappia painettaessa katsotaan, että mikä pvm, aika ja pöytä on valittu ja lähetetään
        //firebaseen
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
            Toast.makeText(Appointment.this, "PC 1 Reserved!", Toast.LENGTH_LONG).show();
            btn1.setClickable(false); // asetetaan buttoni falseksi ettei sitä voi enää muutta ku varaus tehty
        }

        if(btn2.isSelected())
        {
            table=btn2.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 2 Reserved!", Toast.LENGTH_LONG).show();
            btn2.setClickable(false);
        }
        if(btn3.isSelected())
        {
            table=btn3.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 3 Reserved!", Toast.LENGTH_LONG).show();
            btn3.setClickable(false);
        }
        if(btn4.isSelected())
        {
            table=btn4.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 4 Reserved!", Toast.LENGTH_LONG).show();
            btn4.setClickable(false);
        }
        if(btn5.isSelected())
        {
            table=btn5.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 5 Reserved!", Toast.LENGTH_LONG).show();
            btn5.setClickable(false);
        }
        if(btn6.isSelected())
        {
            table=btn6.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 6 Reserved!", Toast.LENGTH_LONG).show();
            btn6.setClickable(false);
        }
        if(btn7.isSelected())
        {
            table=btn7.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 7 Reserved!", Toast.LENGTH_LONG).show();
            btn7.setClickable(false);
        }
        if(btn8.isSelected())
        {
            table=btn8.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 8 Reserved!", Toast.LENGTH_LONG).show();
            btn8.setClickable(false);
        }
        if(btn9.isSelected()) {
            table = btn9.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 9 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn10.isSelected()) {
            table = btn10.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 10 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn11.isSelected()) {
            table = btn11.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 11 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn12.isSelected()) {
            table = btn12.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PC 12 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn13.isSelected()) {
            table = btn13.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 1 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn14.isSelected()) {
            table = btn14.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 2 Reserved!", Toast.LENGTH_LONG).show();
        }
        if(btn15.isSelected()) {
            table = btn15.getText().toString().trim();
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "PS 3 Reserved!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Appointment.this, "Select a table", Toast.LENGTH_LONG).show();
        }

    }
}

