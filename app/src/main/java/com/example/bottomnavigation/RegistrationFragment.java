package com.example.bottomnavigation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFragment extends Fragment {
    TextInputEditText Name;
    TextInputEditText Email;
    TextInputEditText Age;
    TextInputEditText add;
    TextInputEditText date1;
    RadioGroup radioSex;
    Spinner branch;
    ArrayAdapter<CharSequence> adapter;
    CheckBox hindi,english;
    Button Submit;
    TextView Gender;
    TextView Branch;
    TextView language;
    int mYear,mMonth,mDay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.material_registration_from, null);
        Name=view.findViewById(R.id.name1);
        Email=view.findViewById(R.id.email1);
        Age=view.findViewById(R.id.age1);
        add=view.findViewById(R.id.address);

        Gender=(TextView)view.findViewById(R.id.gender1);
        radioSex=(RadioGroup)view.findViewById(R.id.radioSex);
        Branch=(TextView)view.findViewById(R.id.branch);
        branch=(Spinner)view.findViewById(R.id.branch1);
        hindi=(CheckBox)view.findViewById(R.id.hindi);
        english=(CheckBox)view.findViewById(R.id.english);
        language=(TextView)view.findViewById(R.id.lang);
        date1=view.findViewById(R.id.date1);

        date1.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {
                                         // TODO Auto-generated method stub
                                         // To show current date in the datepicker
                                         Calendar mcurrentDate = Calendar.getInstance();
                                         mYear = mcurrentDate.get(Calendar.YEAR);
                                         mMonth = mcurrentDate.get(Calendar.MONTH);
                                         mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                                         DatePickerDialog mDatePicker = new DatePickerDialog(Objects.requireNonNull(getContext()), new DatePickerDialog.OnDateSetListener() {
                                             public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                                                 Calendar myCalendar = Calendar.getInstance();
                                                 myCalendar.set(Calendar.YEAR, selectedyear);
                                                 myCalendar.set(Calendar.MONTH, selectedmonth);
                                                 myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                                                 String myFormat = "dd/MM/yyyy"; //Change as you need
                                                 SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
                                                 date1.setText(sdf.format(myCalendar.getTime()));

                                                 mDay = selectedday;
                                                 mMonth = selectedmonth;
                                                 mYear = selectedyear;
                                             }
                                         }, mYear, mMonth, mDay);
                                         //mDatePicker.setTitle("Select date");
                                         mDatePicker.show();
                                     }
                                 });
        //View form Button
        Submit =(Button)view.findViewById(R.id.send);
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
                    Toast.makeText(getActivity(), "Form Submitted", Toast.LENGTH_SHORT).show();
                   Intent i1 = new Intent(getActivity(), Blank.class);
                    startActivity(i1);

                }
            }
        });
//
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.branch20, android.R.layout.simple_spinner_item);
//
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
        branch.setAdapter(adapter);
        return view;

    }
    private boolean isValideEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }



}

