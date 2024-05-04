package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameEdit, passwordEdit;
    CheckBox checkBox1, checkBox2, checkBox3;
    RadioGroup genderRadioGroup;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        registerButton = findViewById(R.id.button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                StringBuilder courseSelection = new StringBuilder();
                if(checkBox1.isChecked()) {
                    courseSelection.append("BCA");
                }
                if (checkBox2.isChecked()) {
                    courseSelection.append("MCA");
                }
                if (checkBox3.isChecked()) {
                    courseSelection.append("MBA");
                }

                int genderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(genderId);
                String gender = selectedGender != null ? selectedGender.getText().toString() : "Gender not selected";

                String message = "Username: " + username + "\nPassword: " + password + "\nCourse Selection: " + (courseSelection.length() > 0 ? courseSelection.toString(): "No Course Selectee") + "\nGender: " + gender;

                View layout = getLayoutInflater().inflate(R.layout.content_main, null);

                TextView text = layout.findViewById(R.id.toastText);
                text.setText(message);

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

            }
        });
    }
}