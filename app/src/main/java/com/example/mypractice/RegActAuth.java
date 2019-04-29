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
public class RegActAuth extends AppCompatActivity {
Button reg;
EditText email,password;
FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reg_act_auth);
        email=(EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


    reg=(Button) findViewById(R.id.reg);
        firebaseAuth = FirebaseAuth.getInstance();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progressDialog = ProgressDialog.show(RegActAuth.this, "Please Wait", "Processing");

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(RegActAuth.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), "id pass wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


    }

}







//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
//                        .addOnCompleteListener(new oncompleteListene <AuthResult>){
//
//
//                    public void oncomplete(Task<AuthResult> task){
//
//                        if(task.isSuccesful())
//                        {
//                        firebaseAuth.getcurrentuser().getemail();
//                        }
//                        else
//                        {
//
//                        }
//
//
//                    }
//
//
//                }
//            }
//        });
//
//            }
//        });
//            }
//        };
//}
