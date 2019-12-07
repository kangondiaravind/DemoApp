package com.aravind.datapassing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        //Receive Data using Intent
        /*String stringVal = getIntent().getStringExtra("STRING_VAL");
        int intVal = getIntent().getIntExtra("INT_VAL", 0);
        double doubleVal = getIntent().getDoubleExtra("DOUBLE_VAL", 0.00);
        if (stringVal != null && intVal != 0 && doubleVal != 0.00) {
            Toast.makeText(this, "String value is " + stringVal + "\n" + "Integer value is" + intVal + "\n" + "Double value is" + doubleVal, Toast.LENGTH_SHORT).show();
        }*/

        //Receive Data Using Bundle
        Bundle bundle = getIntent().getExtras();
        String stringVal = bundle.getString("STRING_VAL");
        int intVal = bundle.getInt("INT_VAL");
        double doubleVal = bundle.getDouble("DOUBLE_VAL");

        if (stringVal != null && intVal != 0 && doubleVal != 0.00) {
            Toast.makeText(this, "String value is " + stringVal + "\n" + "Integer value is" + intVal + "\n" + "Double value is" + doubleVal, Toast.LENGTH_SHORT).show();
        }
    }
}

