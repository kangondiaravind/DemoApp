package com.aravind.datapassing;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeofServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Button launchUnboundServiceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeof_services_activitity);
        launchUnboundServiceFragment = findViewById(R.id.btn_launc_unbound_service_fragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_launc_unbound_service_fragment:
                UnBoundServiceFragment unBoundServiceFragment = new UnBoundServiceFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fragment_container,unBoundServiceFragment,null);
                ft.commit();
                break;

        }
    }
}
