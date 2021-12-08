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
        private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
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


            }
        }
        // varaus nappia painettaessa katsotaan, että mikä pvm, aika ja pöytä on valittu ja lähetetään
        //firebaseen
    public void Reserve(View v){
        //haetaan valitut aika ja päivä muuttujiin
        String time = etTime.getText().toString().trim();
        String date = etDate.getText().toString().trim();



        //tähä pitäs keksiä joku juttu että tuo pöydän numero vaihtuu sen mukaan mikä on valittu
        // nyt se laittaa aina tuon pöydän 1 iha sama minkä valitsee.
        //Tossa kommentoituna tuo switch jolla se vois ehkä toimia
        String table = btn1.getText().toString().trim();

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();


        /*switch (v.getId())
        {
            case R.id.button26:
                 table = btn1.getText().toString().trim();
                 break;

            case R.id.button27:
                 table = btn2.getText().toString().trim();
                 break;

            case R.id.button28:
                table = btn3.getText().toString().trim();

        }

         */

        // tässäkin jos keksii jonku paremman keinon tehä tuo niin hyvä ku aika pitkä koodin pätkä
        // ja buttoniin 8 asti tehty
        if(btn1.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 1 Reserved!", Toast.LENGTH_LONG).show();
            btn1.setClickable(false); // asetetaan buttoni falseksi ettei sitä voi enää muutta ku varaus tehty
        }

        if(btn2.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 2 Reserved!", Toast.LENGTH_LONG).show();
            btn2.setClickable(false);
        }
        if(btn3.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 3 Reserved!", Toast.LENGTH_LONG).show();
            btn3.setClickable(false);
        }
        if(btn4.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 4 Reserved!", Toast.LENGTH_LONG).show();
            btn4.setClickable(false);
        }
        if(btn5.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 5 Reserved!", Toast.LENGTH_LONG).show();
            btn5.setClickable(false);
        }
        if(btn6.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 6 Reserved!", Toast.LENGTH_LONG).show();
            btn6.setClickable(false);
        }
        if(btn7.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 7 Reserved!", Toast.LENGTH_LONG).show();
            btn7.setClickable(false);
        }
        if(btn8.isSelected())
        {
            FirebaseDatabase.getInstance().getReference("Tables").push().setValue(new Table(date, time, table, userID));
            Toast.makeText(Appointment.this, "Table 8 Reserved!", Toast.LENGTH_LONG).show();
            btn8.setClickable(false);
        }
        else
        {
            Toast.makeText(Appointment.this, "Select a table", Toast.LENGTH_LONG).show();
        }

    }
}

