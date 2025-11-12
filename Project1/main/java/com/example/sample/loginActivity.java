package com.example.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {
    Button login_Button;
    EditText emailEditText, passwordEditTextForLogin;

    Boolean emailError, emailError2, passwordError;
    String email, password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditTextForLogin = findViewById(R.id.passwordEditTextForLogin);
        login_Button = findViewById(R.id.login_Button);

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText()).matches()) {
                    emailEditText.setError("Enter valid Email.");
                    emailError2 = true;
                } else
                    emailError2 = false;
                if (TextUtils.isEmpty(emailEditText.getText())) {
                    emailEditText.setError("Email is required.");
                    emailError = true;
                } else
                    emailError = false;
                if (TextUtils.isEmpty(passwordEditTextForLogin.getText())) {
                    passwordEditTextForLogin.setError("Password is required.");
                    passwordError = true;
                } else
                    passwordError = false;
                if (!emailError && !emailError2 && !passwordError) {
                    email = emailEditText.getText().toString();
                    password = passwordEditTextForLogin.getText().toString();


                    if (email.equals("test@sadjad.ac.ir") && password.equals("123")) {
                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                    }//if
                    else {
                        Toast.makeText(getApplicationContext(),
                                "Invalid Email/Password", Toast.LENGTH_LONG).show();
                    }//else
                }//if
            }//onClick method
        });
    }
}