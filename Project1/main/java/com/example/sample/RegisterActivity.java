package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText firstnameEditText, lastnameEditText, emailEditText, passwordEditText;
    RadioGroup genderRadioGroup;
    RadioButton genderRadioButton;
    CheckBox conditionsCheckBox;
    Button registerButton;
    String firstName, lastName, email, password, gender;
    int genderId;
    Boolean conditions;
    Boolean firstNameError = false;
    Boolean lastNameError = false;
    Boolean emailError = false;
    Boolean passwordError = false;
    Boolean emailError2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_register);
        firstnameEditText = findViewById(R.id.firstnameEditText);
        lastnameEditText = findViewById(R.id.lastnameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        conditionsCheckBox = findViewById(R.id.conditionsCheckBox);
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(firstnameEditText.getText())) {
                    firstnameEditText.setError("First name is required.");
                    firstNameError = true;
                } else
                    firstNameError = false;
                if (TextUtils.isEmpty(lastnameEditText.getText())) {
                    lastnameEditText.setError("Last name is required.");
                    lastNameError = true;
                } else
                    lastNameError = false;
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
                if (TextUtils.isEmpty(passwordEditText.getText())) {
                    passwordEditText.setError("Password is required.");
                    passwordError = true;
                }
                passwordError = false;
                if (!conditionsCheckBox.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You must select the checkbox!", Toast.LENGTH_LONG).show();
                }

                if (!firstNameError && !lastNameError && !emailError && !passwordError && !emailError2 && conditionsCheckBox.isChecked()) {
                    firstName = firstnameEditText.getText().toString();
                    lastName = lastnameEditText.getText().toString();
                    email = emailEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    genderId = genderRadioGroup.getCheckedRadioButtonId();
                    genderRadioButton
                            =
                            findViewById(genderId);
                    gender = genderRadioButton.getText().toString();
                    conditions = conditionsCheckBox.isChecked();
                    Intent intent = new Intent(RegisterActivity.this, ResultActivity.class);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("lastName", lastName);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    intent.putExtra("gender", gender);
                    intent.putExtra("conditions", conditions);
                    startActivity(intent);
                }//if
            }
        });
    }//onCreate
}
