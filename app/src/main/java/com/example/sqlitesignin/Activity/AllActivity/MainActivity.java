package com.example.sqlitesignin.Activity.AllActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitesignin.Activity.Utils.DatabaseHelper;
import com.example.sqlitesignin.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextONe,editTextTwo;
    Button button,button2;
    ActionBar actionBar;
    DatabaseHelper databaseHelper ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.black));

        editTextONe = findViewById(R.id.Lemail);
        editTextTwo = findViewById(R.id.Lpassword);
        button = findViewById(R.id.loginbtn);
        button2 = findViewById(R.id.Signupgo);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();

    }



    @Override
    public void onClick(View view) {

        String email = editTextONe.getText().toString();
         String Password = editTextTwo.getText().toString();

        if(view.getId() == R.id.Signupgo){
            Intent intent = new Intent(MainActivity.this, Signup.class);
            startActivity(intent);
        }else if(view.getId() == R.id.loginbtn){

            Boolean result = databaseHelper.FindPassword( email,Password);

            if(email.equals("") || Password.equals("")){
                Toast.makeText(this,"All field is required",Toast.LENGTH_LONG).show();
            }else{
                if(result == true){
                    Intent intent = new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                    Toast.makeText(this,"SuccessFully login",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Email or password did not match !",Toast.LENGTH_LONG).show();
                }
            }


        }

    }
}