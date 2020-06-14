package com.example.bottomnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegistration extends Activity {
    EditText Name;
    EditText Email;
    EditText Age;
    RadioGroup radioSex;
    Spinner branch;
   // ArrayAdapter<CharSequence>adapter;
    CheckBox hindi,english;
    Button Submit;
    TextView Gender;
    TextView Branch;
    TextView language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_registration_from);
        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Age=(EditText)findViewById(R.id.age);
        Gender=(TextView)findViewById(R.id.gender);
        radioSex=(RadioGroup)findViewById(R.id.radioSex);
        Branch=(TextView)findViewById(R.id.branch);
        branch=(Spinner)findViewById(R.id.branch1);
        hindi=(CheckBox)findViewById(R.id.hindi);
        english=(CheckBox)findViewById(R.id.english);
        language=(TextView)findViewById(R.id.lang);
        //View form Button
        Submit =(Button)findViewById(R.id.send);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().trim().isEmpty()){
                    Name.setError("Please enter your name");
                    Name.requestFocus();
                }
                else if (!isValideEmail(Email.getText().toString()))
                {
                    Email.setError("Please enter your Email");
                    Email.requestFocus();
                }
                else if (Age.getText().toString().trim().isEmpty()){
                    Age.setError("Please enter your");
                    Age.requestFocus();
                }
                else {
                    Toast.makeText(MainRegistration.this,"Form Submitted",Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(), BlankFragment.class);
                 startActivity(i1);

                }
            }
        });
//
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.branch20, android.R.layout.simple_spinner_item);
//
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// 
        branch.setAdapter(adapter);

    }
    private boolean isValideEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }



}
