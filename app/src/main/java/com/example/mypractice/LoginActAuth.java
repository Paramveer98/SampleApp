package com.example.mypractice;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActAuth extends AppCompatActivity {
    Button login;
    EditText email,password;
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_act_auth);
        email=(EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        login=(Button) findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progressDialog = ProgressDialog.show(LoginActAuth.this, "Please Wait", "Processing");

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(LoginActAuth.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressDialog.dismiss();

                                if (task.isSuccessful()) {

                                    firebaseAuth.getCurrentUser().getEmail();
                                    Toast.makeText(getApplicationContext(), firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


    }
}




