package com.aravind.datapassing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListViewFragment extends Fragment {


    int[] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    String[] names = {"Aravind","Raj"};
    String[] designation = {"SE","SE"};
    ListView lv;
    public CustomListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custome_list_view, container, false);
        lv = view.findViewById(R.id.list_disp);
        CustomListViewOnFragment customListViewOnFragment = new CustomListViewOnFragment();
        lv.setAdapter(customListViewOnFragment);
        return view;
    }


    public class CustomListViewOnFragment extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
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
            if(convertView==null) {
                convertView = getLayoutInflater().inflate(R.layout.custom_list_view_container, null);
            }
            ImageView imagess = convertView.findViewById(R.id.img_disp);
            TextView txtNames = convertView.findViewById(R.id.txt_name);
            TextView txtDesignation = convertView.findViewById(R.id.txt_designation);

            txtNames.setText(names[position]);
            txtDesignation.setText(designation[position]);
            imagess.setImageResource(images[position]);
            return convertView;
        }
    }
}
