package com.example.myhustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText fme,occup,loc,pNumb,password;
    Button reg;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fme=findViewById(R.id.rName);
        occup=findViewById(R.id.Occupation);
        loc=findViewById(R.id.Loc);
        pNumb=findViewById(R.id.pnum);
        reg=findViewById(R.id.reg);
        password=findViewById(R.id.pword);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("user");
                String name=fme.getText().toString();
                String occupation=occup.getText().toString();
                String location=loc.getText().toString();
                String pNumber=pNumb.getText().toString();
                String pword=password.getText().toString();

              UserClass classHelper=new UserClass(name,occupation,location,pNumber,pword);
              reference.child(pNumber).setValue("classHelper");
              //  reference.setValue("h");




            }
        });


    }
}
