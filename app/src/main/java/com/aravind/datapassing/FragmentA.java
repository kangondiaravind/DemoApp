package com.aravind.datapassing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        //Receving Data from activity A
        Bundle b = getArguments();
        String stringVal = b.getString("STRING_VAL");
        int intVal = b.getInt("INT_VAL");
        double doubleVal = b.getDouble("DOUBLE_VAL");

        if (stringVal != null && intVal != 0 && doubleVal != 0.00) {
            Toast.makeText(getActivity(), "String value is " + stringVal + "\n" + "Integer value is" + intVal + "\n" + "Double value is" + doubleVal, Toast.LENGTH_SHORT).show();
        }
        return v;
    }

}
