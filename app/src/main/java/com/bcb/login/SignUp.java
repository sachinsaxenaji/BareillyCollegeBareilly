package com.bcb.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bcb.user.bareillycollegebareilly.MainScreen;
import com.bcb.user.bareillycollegebareilly.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText t1,t2;
    private FirebaseAuth mAuth;
    private ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

//        mAuth = FirebaseAuth.getInstance();
//
//        t1 = (EditText)findViewById(R.id.email);
//        t2= (EditText)findViewById(R.id.password);
//        p1= (ProgressBar) findViewById(R.id.progressBar);
//
//
//        //Firebase.setAndroidContext(getApplicationContext());
//
//
//    }
//
//    public void click(View view){
//
//      String email = t1.getText().toString();
//        String password = t2.getText().toString();
//        if(email.equals("")|password.equals("")) {
//            Toast.makeText(this, "please fill all the information", Toast.LENGTH_SHORT).show();
//            p1.setVisibility(View.GONE);
//
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//
//            t1.setError("plese Enter Valid Format Email");
//        }
//        if(password.length()<6){
//            t2.setError("minimum password length is 6");
//            t2.requestFocus();
//        }
//        p1.setVisibility(View.GONE);
//        p1.setVisibility(View.VISIBLE);
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                Log.d("messege", "createUserWithEmail:success");
//                                if(task.isSuccessful()){
//
//                                    Toast.makeText(SignUp.this, "Yoy hace registered sucessfully", Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(SignUp.this,MainScreen.class));
//                                    finish();
//                                    p1.setVisibility(View.GONE);
//
//                                }
//                                if (task.getException() instanceof FirebaseApiNotAvailableException){
//                                    Toast.makeText(SignUp.this, "user already registered", Toast.LENGTH_SHORT).show();
//                                    p1.setVisibility(View.GONE);
//                                }
//                                //FirebaseUser user = mAuth.getCurrentUser();
//                                //updateUI(user);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Log.w("msg", "createUserWithEmail:failure", task.getException());
//                                Toast.makeText(SignUp.this, "Authentication failed.",
//                                        Toast.LENGTH_SHORT).show();
//                                p1.setVisibility(View.GONE);
//                                //updateUI(null);
//                            }
//
//                            // ...
//                        }
//                    });
//
////            User user = new User();
////            user.setName(name);
////            user.setAddress(address);
////            //Firebase firebase = new Firebase(Config.url);
////            //firebase.child("person").push().setValue(user);
////            // Write a message to the database
////            FirebaseDatabase database = FirebaseDatabase.getInstance();
////            DatabaseReference myRef = database.getReference();
////
////            myRef.child("User").push().setValue(user);
////            Toast.makeText(this, "login sucessfully done", Toast.LENGTH_SHORT).show();
////            startActivity(new Intent(SignUp.this,MainScreen.class));
//
//
//


    }
}
