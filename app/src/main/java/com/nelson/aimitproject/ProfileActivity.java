package com.nelson.aimitproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "Nech";
    EditText uname, pwd;
    Button btnlogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        uname = findViewById(R.id.etUname);
        pwd = findViewById(R.id.etPasswords);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;


                String mail = uname.getText().toString();
                final String email = mail+".171739@staloysius.ac.in";
                String password = "000000";
                Log.d(TAG, "setupFirebseAuth: "+email+password);



                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ProfileActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    Toast.makeText(ProfileActivity.this, "Heklllo", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(ProfileActivity.this, SendNotifications.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(ProfileActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    uname.setText("You are not Admin");
                                    Handler h = new Handler(){
                                        @Override
                                        public void handleMessage(Message msg) {
                                            finish();
                                        }
                                    };

                                    h.sendEmptyMessageDelayed(0, 2500);

                                }

                                // ...
                            }
                        });
            }
        });
    }
}
