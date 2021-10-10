package com.example.mealmonkey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Registration extends AppCompatActivity
{
    private EditText regname,regemail,regPhone,regAddress,regPassword,regConfirm;
    private  Button Signup;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private  TextView login;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        /*firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("UserInfo");*/

        mAuth= FirebaseAuth.getInstance();

        regname =findViewById(R.id.name_edt);
        regemail= findViewById(R.id.email_edt);
        regPhone = findViewById(R.id.mobile_edt);
        regAddress= findViewById(R.id.add_edt);
        regPassword= findViewById(R.id.password_edt);
        regConfirm= findViewById(R.id.confirm_pass_edt);

        progressBar= findViewById(R.id.progressBar);


        Signup =findViewById(R.id.signup_button);

        Signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {




                registernewUser();

            }
        });



    }



    private void registernewUser()
    {
        progressBar.setVisibility(View.GONE);

        String email,password,phoneno,useraddress,name;
        email = regemail.getText().toString();
        password= regPassword.getText().toString();
        phoneno= regPhone.getText().toString();
        useraddress= regAddress.getText().toString();
        name= regname.getText().toString();


        


        /*rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users/");

        UserHelperClass helperClass = new UserHelperClass(name,email,phoneno,password);
        reference.setValue(helperClass);
*/
        if(TextUtils.isEmpty(email))
        {
            regemail.setError("enter the valid email Address");
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            regPassword.setError("Enter the password");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();

                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", userid);
                    hashMap.put("username", name);
                    hashMap.put("useremail", email);
                    hashMap.put("phoneno", phoneno);
                    hashMap.put("password", password);

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task)
                        {
                            Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(Registration.this,MainLogin_Screen.class);
                            startActivity(intent);
                            finish();
                        }
                    });


                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"Registartion Failed",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }



            }
        });




    }


    }

