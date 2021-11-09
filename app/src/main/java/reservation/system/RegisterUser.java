package reservation.system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    private EditText fullName, emailAddress, passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerUser=(Button) findViewById(R.id.btnregisterUser);
        registerUser.setOnClickListener(this);

        fullName = (EditText) findViewById(R.id.editTextfullName);
        emailAddress=(EditText) findViewById(R.id.editTextEmail);
        passWord=(EditText) findViewById(R.id.editTextPassword);
    }

    @Override
    public void onClick(View view) {
        registerUser();
    }

    private void registerUser()
    {
        String Name = fullName.getText().toString().trim();
        String email = emailAddress.getText().toString().trim();
        String password = passWord.getText().toString().trim();

        //Tsekataan onko boxeissa jotain, jos ei niin näytetään errorviesti
        if(Name.isEmpty())
        {
        fullName.setError("Full name is required!");
        fullName.requestFocus();
        return;
        }

        if(email.isEmpty())
        {
            emailAddress.setError("Email is required!");
            emailAddress.requestFocus();
            return;
        }
        //katsotaan sisältääkö annettu sähköposti tarvittavat merkit esim @ jne.
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailAddress.setError("Use valid email");
            emailAddress.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            passWord.setError("Password is required!");
            passWord.requestFocus();
            return;
        }

        //firebase hyväksyy vähintään 6 merkin pituisen salasanan.
        if(password.length()<6)
        {
            passWord.setError("Password length should be at least 6 characters");
            passWord.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    User user = new User(Name, email);
                    //hakee rekisteröityneen henkilön id:n.
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance()
                            .getCurrentUser().getUid())
                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterUser.this, "User has been registered succesfully!",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(RegisterUser.this, "Failed to register. Try again!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(RegisterUser.this, "Failed to register!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}