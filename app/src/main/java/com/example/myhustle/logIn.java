package com.example.myhustle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class logIn extends AppCompatActivity {
    EditText phoneNumber,password;
    Button buttonLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


    }
    private Boolean validatePhone() {
        String val = phoneNumber.getText().toString();
        if (val.isEmpty()) {
            phoneNumber.setError("Firld cannot be empty");
            return false;
        }else {
            phoneNumber.setError(null);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Firld cannot be empty");
            return false;
        }else {
            password.setError(null);
            return true;
        }

}

    public void logUser(View view){
        //validate log in information
        if(!validatePhone() | !validatePassword()){
            return;
        }else {
            isUser();
        }
    }

    private void isUser() {

       final String userPhone=phoneNumber.getText().toString();
        String Userpasssword=password.getText().toString();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
        Query checkUser= ref.orderByChild("userPhone").equalTo(userPhone);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    phoneNumber.setError(null);
                    String phoneNumberfrmDb=dataSnapshot.child(userPhone).child("password").getValue(String.class);
                    if (phoneNumberfrmDb.equals(userPhone)){

                        phoneNumber.setError(null);
                        String nameFromDb=dataSnapshot.child(userPhone).child("name").getValue(String.class);
                        String occupationFromDb=dataSnapshot.child(userPhone).child("occupation").getValue(String.class);
                        String locationFromDb=dataSnapshot.child(userPhone).child("location").getValue(String.class);
                        String phoneFromDb=dataSnapshot.child(userPhone).child("phone").getValue(String.class);
                        String passwordFromDb=dataSnapshot.child(userPhone).child("password").getValue(String.class);

                        Intent intent=new Intent(getApplicationContext(),Content.class);
                        intent.putExtra("name",nameFromDb);
                        intent.putExtra("occupation",occupationFromDb);
                        intent.putExtra("location",locationFromDb);
                        intent.putExtra("phone",phoneFromDb);
                        intent.putExtra("password",passwordFromDb);
                        startActivity(intent);
                    }else {
                        password.setError("wrong password");
                    }
                }
                else {
                    phoneNumber.setError("No such user exist");
                    phoneNumber.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}