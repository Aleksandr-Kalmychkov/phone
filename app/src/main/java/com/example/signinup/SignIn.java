package com.example.signinup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class SignIn extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);
    }

    public void SignInOnClick(View view)
    {
        /*EditText emailField = findViewById(R.id.emailField);
        EditText passwordField = findViewById(R.id.passwordField);
        String URL = "";

        if (emailField.getText().toString().equals("") || passwordField.getText().toString().equals(""))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ошибка!").setMessage("Необходимо заполнить все поля!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        postTask sendPost = new postTask();
        //sendPost.execute(emailField.getText().toString(), passwordField.getText().toString(), URL);*/

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void SignUpOnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Registration.class);
        startActivity(intent);
    }
}