package reservation.system;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Appointment extends AppCompatActivity implements View.OnClickListener{
        private Button btn1,btn2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_appointment);

            btn1 = (Button) findViewById(R.id.button26);
            btn1.setOnClickListener(this);

            btn2 = (Button) findViewById(R.id.button27);
            btn2.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {

        if(btn1.isSelected()) {

            btn1.setSelected(false);
        }
        else{
            btn1.setSelected(true);
        }
    }
}

