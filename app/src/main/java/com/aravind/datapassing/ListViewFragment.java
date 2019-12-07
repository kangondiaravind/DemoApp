package com.aravind.datapassing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    ListView listOfOperatingSystems;


    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        String[] os = {"Windows", "Android", "Blackberry"};

        listOfOperatingSystems = view.findViewById(R.id.disp_list);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, os);
        listOfOperatingSystems.setAdapter(stringArrayAdapter);

        return view;
    }

}
