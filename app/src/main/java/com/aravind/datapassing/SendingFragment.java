package com.aravind.datapassing;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendingFragment extends Fragment {

    private EditText stringVal;
    private EditText intVal;
    private EditText doubleVal;
    DataListner dataListner;
    Button sendDataToActivity;
    Button sendDataFragmentToFragment;


    public SendingFragment() {

    }

    /*public SendingFragment(DataListner dataListner) {
        this.dataListner = dataListner;
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityA) {
            dataListner = (ActivityA) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement NameDialogListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sending, container, false);
        stringVal = v.findViewById(R.id.et_string);
        intVal = v.findViewById(R.id.et_int);
        doubleVal = v.findViewById(R.id.et_double);
        sendDataToActivity = v.findViewById(R.id.btn_send_to_activity_using_interface);
        sendDataFragmentToFragment = v.findViewById(R.id.btn_send_fragment_tofragmenyt_using_interface);

        sendDataFragmentToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 fetchDatafromTextFields();
            }
        });

        sendDataToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchDatafromTextFields();
            }
        });
        return v;
    }

    public void fetchDatafromTextFields() {
        String sVal = stringVal.getText().toString();
        int iVal = Integer.parseInt(intVal.getText().toString());
        double dVal = Double.parseDouble(doubleVal.getText().toString());
        //Sending data to Activity A through interface
        //Fragment to Activity Communication
        if (!(stringVal.getText().toString().isEmpty() && intVal.getText().toString().isEmpty() && doubleVal.getText().toString().isEmpty())) {
            dataListner.onDataListner(sVal, iVal, dVal);
        } else {
            Toast.makeText(getActivity(), "Enter all fieslds", Toast.LENGTH_SHORT).show();
        }
    }

}
