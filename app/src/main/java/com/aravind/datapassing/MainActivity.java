package com.aravind.datapassing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button launchActivityOrFragment;
    Button launchListViewandCustomListViewActivity;
    Button btnUnboundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchActivityOrFragment = findViewById(R.id.btn_launchA);
        launchListViewandCustomListViewActivity = findViewById(R.id.btn_list_view_on_activity);
        btnUnboundService = findViewById(R.id.btn_unbound_service);

        launchActivityOrFragment.setOnClickListener(this);
        launchListViewandCustomListViewActivity.setOnClickListener(this);
        btnUnboundService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Activity and Fragments
            case R.id.btn_launchA:
                Intent intent = new Intent(MainActivity.this, ActivityA.class);
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            //List Views and Recyclerviews
            case R.id.btn_list_view_on_activity:
                Intent intent1 = new Intent(MainActivity.this, TypeofListsActivity.class);
                startActivity(intent1);
                //Services
            case R.id.btn_unbound_service:
                Intent services = new Intent(MainActivity.this, TypeofServiceActivity.class);
                startActivity(services);
            default:
                break;
        }
    }
}
