package com.aravind.datapassing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    //String[] names = {"Aravind", "Raj"};

    List<String> names = new ArrayList<>();


    String[] designation = {"SE", "SE"};

    int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        names.add("Aravind");
        names.add("Raj");
        final CustomListAdapter adapter = new CustomListAdapter();
        lv = findViewById(R.id.list_disp);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListViewActivity.this, "index is " + position, Toast.LENGTH_SHORT).show();
                removeSingleItem(adapter, position);
            }
        });
    }

    public class CustomListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.custom_list_view_container, null);
            }
            ImageView imagess = convertView.findViewById(R.id.img_disp);
            TextView txtNames = convertView.findViewById(R.id.txt_name);
            TextView txtDesignation = convertView.findViewById(R.id.txt_designation);

            txtNames.setText(names.get(position));
            txtDesignation.setText(designation[position]);
            imagess.setImageResource(images[position]);


            return convertView;
        }
    }

    private void removeSingleItem(CustomListAdapter adapter, int posistion) {
        names.remove(posistion);
        adapter.notifyDataSetChanged();
    }

}
