package com.aravind.datapassing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TypeofListsActivity extends AppCompatActivity {

    Button listViewOnActivity;
    Button listViewOnFragment;
    Button customlistViewOnActivity;
    Button customlistViewOnFragment;
    Button btnRecyclerViewOnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_activities);

        listViewOnActivity = findViewById(R.id.btn_list_view_on_activity);
        listViewOnFragment = findViewById(R.id.btn_list_view_on_fragment);
        customlistViewOnActivity = findViewById(R.id.btn_custom_list_view_on_activity);
        customlistViewOnFragment = findViewById(R.id.btn_custom_list_view_on_Fragment);
        btnRecyclerViewOnActivity = findViewById(R.id.btn_recycler_view_on_activity);

        listViewOnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeofListsActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        listViewOnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listViewOnActivity.setVisibility(View.GONE);
                listViewOnFragment.setVisibility(View.GONE);
                customlistViewOnActivity.setVisibility(View.GONE);
                customlistViewOnFragment.setVisibility(View.GONE);
                btnRecyclerViewOnActivity.setVisibility(View.GONE);

                ListViewFragment listViewFragment = new ListViewFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fragmentcontainer, listViewFragment, null);
                ft.commit();
            }
        });

        customlistViewOnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeofListsActivity.this, CustomListViewActivity.class);
                startActivity(intent);
            }
        });

        customlistViewOnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listViewOnActivity.setVisibility(View.GONE);
                listViewOnFragment.setVisibility(View.GONE);
                customlistViewOnActivity.setVisibility(View.GONE);
                customlistViewOnFragment.setVisibility(View.GONE);
                btnRecyclerViewOnActivity.setVisibility(View.GONE);

                CustomListViewFragment listViewFragment = new CustomListViewFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fragmentcontainer, listViewFragment, null);
                ft.commit();
            }
        });
    }
}
