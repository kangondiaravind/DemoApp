package com.aravind.datapassing;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity implements DataListner,AddListener {

    private EditText stringValue;
    private EditText doubleValue;
    private EditText intValue;
    Button sendDataToActivityUsingIntent;
    Button sendToActivityUsingBundle;
    Button sendToFragmentUsingBundle;
    Button launchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        stringValue = findViewById(R.id.et_string);
        doubleValue = findViewById(R.id.et_double);
        intValue = findViewById(R.id.et_int);
        sendDataToActivityUsingIntent = findViewById(R.id.btn_send_to_activity_using_intent);
        sendToActivityUsingBundle = findViewById(R.id.btn_send_to_activity_using_bundle);
        sendToFragmentUsingBundle = findViewById(R.id.btn_send_to_fragment_using_bundle);
        launchFragment = findViewById(R.id.launch_fragment);
        new ClassA(ActivityA.this);
        UnBoundService unBoundService = new UnBoundService();
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            } else {

                sendDataToActivityUsingIntent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!(stringValue.getText().toString().isEmpty() && intValue.getText().toString().isEmpty() && doubleValue.getText().toString().isEmpty())) {
                            Intent intent = new Intent(ActivityA.this, ActivityB.class);
                            intent.putExtra("STRING_VAL", stringValue.getText().toString());
                            intent.putExtra("INT_VAL", Integer.parseInt(intValue.getText().toString()));
                            intent.putExtra("DOUBLE_VAL", Double.parseDouble(doubleValue.getText().toString()));
                            startActivity(intent);
                        } else {
                            Toast.makeText(ActivityA.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                sendToActivityUsingBundle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!(stringValue.getText().toString().isEmpty() && intValue.getText().toString().isEmpty() && doubleValue.getText().toString().isEmpty())) {
                            Intent intent = new Intent(ActivityA.this, ActivityB.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("STRING_VAL", stringValue.getText().toString());
                            bundle.putInt("INT_VAL", Integer.parseInt(intValue.getText().toString()));
                            bundle.putDouble("DOUBLE_VAL", Double.parseDouble(doubleValue.getText().toString()));
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ActivityA.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //Launch Sending Fragment inside the fragment_container of Activity A
                launchFragment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SendingFragment s = new SendingFragment();
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(R.id.fragment_container, s, null);
                        ft.addToBackStack(SendingFragment.class.getName());
                        ft.commit();
                    }
                });

                //Sending data from ActivityA to FragmentA
                sendToFragmentUsingBundle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!(stringValue.getText().toString().isEmpty() && intValue.getText().toString().isEmpty() && doubleValue.getText().toString().isEmpty())) {
                            FragmentA f = new FragmentA();
                            Bundle bundle = new Bundle();
                            bundle.putString("STRING_VAL", stringValue.getText().toString());
                            bundle.putInt("INT_VAL", Integer.parseInt(intValue.getText().toString()));
                            bundle.putDouble("DOUBLE_VAL", Double.parseDouble(doubleValue.getText().toString()));
                            f.setArguments(bundle);
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment_container, f, null);
                            ft.commit();
                        } else {
                            Toast.makeText(ActivityA.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }


    //Receiving data from SendingFragment
    @Override
    public void onDataListner(String stringVal, int intVal, double doubleVal) {
        sendDataToRecevingFragment(stringVal, intVal, doubleVal);
    }

    //captured the data which has been send from sendingFragment and again sending it back to Receving Fragment
    // (Fragment to Fragment Communication)

    public void sendDataToRecevingFragment(String stringVal, int intVal, double doubleVal) {
        RecevingFragment recevingFragment = new RecevingFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, recevingFragment);
        Toast.makeText(this, "String value is " + stringVal + "\n" + "Integer value is" + intVal + "\n" + "Double value is" + doubleVal, Toast.LENGTH_SHORT).show();
        ft.commit();
    }

    @Override
    public void add(int res) {
        System.out.println("Value is" +res);
        Toast.makeText(this, "Value is " +30, Toast.LENGTH_SHORT).show();
    }
}
