package com.example.bottomnavigation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom1);
        textView=findViewById(R.id.task);
        loadFragment(new ContactFragment());
        textView.setText("Contact Details");
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener );


      //final   int commit = getSupportFragmentManager().beginTransaction().replace(R.id.contact, new Contact()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment=null;

            switch (item.getItemId())
            {
                case R.id.contact:
                    fragment=new ContactFragment();

                     textView.setText("Contact Details");
                 //       textView.setTextColor(Color.parseColor("#ffffff"));

                  //  fragment=new DescriptionFragment();
//                    Intent i = new Intent(getApplicationContext(), Contact.class);
//                    startActivity(i);
                    break;
                case R.id.places:
                    fragment=new GridFragment();
                    textView.setText("Country Flags");
//                    Intent i1 = new Intent(getApplicationContext(), MainActivityGrid.class);
//                    startActivity(i1);
                    break;

                case R.id.form:
                    fragment=new RegistrationFragment();
                    textView.setText("Registration Details");
//                    Intent i2 = new Intent(getApplicationContext(), MainRegistration.class);
//                    startActivity(i2);
                    break;
                case R.id.more:
                    fragment = new MainActivity();
                    textView.setText("Tab layout");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
           // getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFragment).commit();
            return loadFragment(fragment);
        }

    };
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

