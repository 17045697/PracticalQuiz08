package com.example.a17045697.practicalquiz08;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    TextView tvname;
    TextView tvAge;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("name","No Name");
        int age = prefs.getInt("age", 0);
        etName.setText(name);
        etAge.setText(String.valueOf(age));
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strname = etName.getText().toString();
        int age  = Integer.parseInt(etAge.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit  = prefs.edit();
        preEdit.putString("name", strname);
        preEdit.putInt("age",age);
        preEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = findViewById(R.id.editTextAge);
        etName = findViewById(R.id.editTextName);
        tvAge = findViewById(R.id.textViewAge);
        tvname = findViewById(R.id.textViewName);

        etAge.requestFocus();


    }
}
