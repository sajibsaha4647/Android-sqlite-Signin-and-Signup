package com.example.sqlitesignin.Activity.AllActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitesignin.Activity.ActivityModel.User_Details;
import com.example.sqlitesignin.Activity.Utils.DatabaseHelper;
import com.example.sqlitesignin.R;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextname,editTextemail,editTextpassword;
    private Button button;

    User_Details user_details  = new User_Details();
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editTextname = findViewById(R.id.SName);
        editTextemail = findViewById(R.id.SEmail);
        editTextpassword = findViewById(R.id.Spassword);
        button = findViewById(R.id.SignBtn) ;
        button.setOnClickListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }

    boolean isEmailValid(CharSequence email) { //check email address
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void onClick(View view) {

        String name = editTextname.getText().toString();
        String email = editTextemail.getText().toString();
        String password = editTextpassword.getText().toString();

        if(name.equals("") || email.equals("") || password.equals("")){
            Toast.makeText(this,"All field are required",Toast.LENGTH_LONG).show();
        }else if(!isEmailValid(email)){
            Toast.makeText(this,"Invalid email address",Toast.LENGTH_LONG).show();
        }else if(password.length() <= 5){
            Toast.makeText(this,"Password length must be 6 char.",Toast.LENGTH_LONG).show();
        }else{
            user_details.setName(name);
            user_details.setEmail(email);
            user_details.setPassword(password);

            long rowId =  databaseHelper.InsertsignupDetails(user_details);

            if(rowId>0){
                Toast.makeText(this,"User registration successfull",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Registration unsuccessfull",Toast.LENGTH_LONG).show();
            }
        }



    }

}