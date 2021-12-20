package reservation.system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    private Button registerUser;
    private FirebaseAuth mAuth;
    private EditText editTextfullName, editTextEmail, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerUser=(Button) findViewById(R.id.btnregisterUser);
        registerUser.setOnClickListener(this);

        editTextfullName = (EditText) findViewById(R.id.fullName);
        editTextEmail =(EditText) findViewById(R.id.Email);
        editTextPassword =(EditText) findViewById(R.id.Password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnregisterUser:
                registerUser();
                break;
        }
    }

    private void registerUser()
    {
        String fullName = editTextfullName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //Tsekataan onko boxeissa jotain, jos ei niin näytetään errorviesti
        if(fullName.isEmpty())
        {
        editTextfullName.setError("Syötä etunimi ja sukunimi!");
        editTextfullName.requestFocus();
        return;
        }

        if(email.isEmpty())
        {
            editTextEmail.setError("Syötä sähköpostiosoite!");
            editTextEmail.requestFocus();
            return;
        }
        //katsotaan sisältääkö annettu sähköposti tarvittavat merkit esim @ jne.
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Sähköpostiosoite ei kelpaa!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Syötä salasana!");
            editTextPassword.requestFocus();
            return;
        }

        //firebase hyväksyy vähintään 6 merkin pituisen salasanan.
        if(password.length()<6)
        {
            editTextPassword.setError("Salasanan pituus vähintään kuusi merkkiä!");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    User user = new User(fullName, email);
                    //hakee rekisteröityneen henkilön id:n.
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance()
                            .getCurrentUser().getUid())
                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterUser.this, "Käyttäjän rekisteröinti onnistui!",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(RegisterUser.this, MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(RegisterUser.this, "Rekisteröinti ei onnistunut. Yritä uudelleen!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(RegisterUser.this, "Rekisteröinti ei onnistunut!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}