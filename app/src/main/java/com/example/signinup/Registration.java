package com.example.signinup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);
    }

    public void SignUpOnClick(View view)
    {
        //TODO Шаблон POST-запроса при регистрации
        EditText regEmailField = findViewById(R.id.regEmailField);
        EditText regPasswordField = findViewById(R.id.regPasswordField);
        EditText regPasswordField2 = findViewById(R.id.regPasswordField2);
        EditText nameField = findViewById(R.id.personNameField);
        EditText surnameField = findViewById(R.id.personSurnameField);
        String URL = "";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (regEmailField.getText().toString().equals("")
                || regPasswordField.getText().toString().equals("")
                || regPasswordField2.getText().toString().equals("")
                || nameField.getText().toString().equals("")
                || surnameField.getText().toString().equals(""))
        {
            builder.setTitle("Ошибка!").setMessage("Необходимо заполнить все поля!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        if (!MyHelper.checkEmail(regEmailField.getText().toString()))
        {
            builder.setTitle("Ошибка!").setMessage("Неверный email!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }
        if (!regPasswordField.getText().toString().equals(regPasswordField2.getText().toString()))
        {
            builder.setTitle("Ошибка!").setMessage("Пароли не совпадают!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }
        if (!MyHelper.checkPassword(regPasswordField.getText().toString()))
        {
            builder.setTitle("Ошибка!").setMessage("Пароль должен содержать как минимум одну заглавную букву, одну цифру и один символ! Длина пароля не менее 8-ми символов!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }


        postTask sendPost = new postTask();
        //sendPost.execute(regEmailField.getText().toString(), regPasswordField.getText().toString(), nameField.getText().toString(), surnameField.getText().toString(), URL);
    }

    public void SignInOnClick(View view)
    {
        finish();
    }
}