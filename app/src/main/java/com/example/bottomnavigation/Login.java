package com.example.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
   Button b1;

   TextInputEditText ed1,ed2;
    TextInputLayout edl3,ed4;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        b1=(Button)findViewById(R.id.submit);
        ed1= findViewById(R.id.mobile);
        ed2=findViewById(R.id.pass);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                if(ed1.getText().toString().isEmpty())
                {
                    ed1.setError("This Field Can't be blank");
                    ed1.requestFocus();
                }
                if(ed1.getText().toString().length()<10 || ed1.getText().toString().length()>10)
                {
                    ed1.setError(" Number should be 10 digit");
                    ed1.requestFocus();
                }


                if((ed2.getText().toString().matches(".*[0-9]{1,}.*") && ed2.getText().toString().matches(".*[@#$]{1,}.*") && ed2.getText().toString().length()>=6 && ed2.getText().toString().length()<=20)&& (ed1.getText().toString().length()==10))
                {

                   Toast.makeText(Login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Bottom.class);
                    startActivity(i);
                }
               else if(ed2.getText().toString().isEmpty())
                {
                    ed2.setError("This Field Can't be blank");
                    ed2.requestFocus();
                }
                else
                {
                    ed2.setError("Your password must be contain at least 1 digit, 1 alphabet, 1 special character and at least 6 character in length");
                }
            }
        });


    }
}


