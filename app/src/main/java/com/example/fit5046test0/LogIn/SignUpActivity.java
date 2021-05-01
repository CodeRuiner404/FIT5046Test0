package com.example.fit5046test0.LogIn;

import android.content.Intent;
import android.os.Bundle;

import com.example.fit5046test0.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fit5046test0.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignUpActivity extends AppCompatActivity {
    private EditText emailET,passwordET,firstNameET,lastNameET;
    private ActionBar actionBar;
    private FirebaseAuth auth;
    private Button registerB;
    private DatabaseReference fbDatabase;
    private FirebaseFirestore fbStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // set back to sign in activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //get view
        emailET = findViewById(R.id.sign_up_email);
        passwordET = findViewById(R.id.sign_up_password);
        firstNameET = findViewById(R.id.sign_up_fname);
        lastNameET = findViewById(R.id.sign_up_lname);
        registerB = findViewById(R.id.sign_up_register);

        //Firebase initialization
        auth = FirebaseAuth.getInstance();
        fbDatabase = FirebaseDatabase.getInstance().getReference();
        fbStore = FirebaseFirestore.getInstance();

        //prevent repetitive sign up
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        //
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get input
                final String email = emailET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                final String firstName = firstNameET.getText().toString();
                final String lastName = lastNameET.getText().toString();

                //check the input
                if(TextUtils.isEmpty(email)){
                    emailET.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordET.setError("Password is Required.");
                    return;
                }

                //pass input to firebase
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>(){
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(SignUpActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }

                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpActivity.this, "Verification Email Can't be sent.", Toast.LENGTH_SHORT).show();
                                }
                            });

                            //Store the user information
                            String userID = auth.getCurrentUser().getUid();
                            DocumentReference documentReference = fbStore.collection("users").document(userID);
                            Map<String,String> userInfo = new HashMap<>();
                            userInfo.put("firstName",firstName);
                            userInfo.put("lastName",lastName);
                            documentReference.set(userInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("SignUpActivity", "user information have been stored!");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("SignUpActivity", "user information don't stored!");
                                }
                            });

                            // Go to Sign in activity
                            startActivity(new Intent(getApplicationContext(),SignInActivity.class));

                        }else{
                            Toast.makeText(SignUpActivity.this, "Sign up failed! " , Toast.LENGTH_SHORT).show();
                            Log.d("SignUpActivity", "Sign up failed!"+task.getException().getMessage() );
                        }

                    }
                });

            }
        });



    }


}