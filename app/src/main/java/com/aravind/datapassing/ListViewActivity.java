package com.aravind.datapassing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity  {

    ListView listOfOperatingSystems;

    List<String> data;

    Button updateSingleItem;
    Button moveSingleItem;
    Button removeMultipleItem;
    Button replaceWithNewList;

    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listOfOperatingSystems = findViewById(R.id.disp_list);
        updateSingleItem = (Button) findViewById(R.id.btn_updateSingleItem);
        moveSingleItem = (Button) findViewById(R.id.btn_moveSingleItem);
        removeMultipleItem = (Button) findViewById(R.id.btn_removeMultipleItem);
        replaceWithNewList = (Button) findViewById(R.id.btn_replace_with_new_List);

        // String[] os = {"Windows", "Android", "Blackberry"};

        data = new ArrayList<>();
        data.add("MasterCard");
        data.add("Visa Card");
        data.add("Diners Club");
        data.add("Maestero");
        data.add("Discover");
        data.add("American Express");
        data.add("Rupay");

        stringArrayAdapter = new ArrayAdapter(ListViewActivity.this, R.layout.support_simple_spinner_dropdown_item, data);
        listOfOperatingSystems.setAdapter(stringArrayAdapter);


        listOfOperatingSystems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removeSingleItem(stringArrayAdapter, position);
            }
        });

        updateSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upDateSingleItem();
            }
        });

        moveSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveSingleItem();
            }
        });

        removeMultipleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    removeMultipleItems();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        replaceWithNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceWithNewList();
            }
        });

    }

    //removes the current item from the list
    private void removeSingleItem(ArrayAdapter<String> stringArrayAdapter, int posistion) {
        data.remove(posistion);
        stringArrayAdapter.remove(String.valueOf(posistion));
    }

    public void upDateSingleItem() {
        String newValue = "I Like Maestero";
        int updateIndex = 2;
        data.set(updateIndex, newValue);
        listOfOperatingSystems.setAdapter(stringArrayAdapter);
    }

    public void moveSingleItem() {
        int fromPosition = 1;
        int toPosition = 4;
        String item = data.get(fromPosition);
        data.remove(fromPosition);
        data.add(toPosition, item);
        listOfOperatingSystems.setAdapter(stringArrayAdapter);

    }

    public void removeMultipleItems() throws Exception {
        int startIndex = 1; // inclusive
        int endIndex = 3;   // exclusive
        data.subList(startIndex, endIndex).clear();
        listOfOperatingSystems.setAdapter(stringArrayAdapter);

    }

    public void replaceWithNewList() {
        data.clear();
        ArrayList<String> newList = new ArrayList<>();
        newList.add("Lion");
        newList.add("Wolf");
        newList.add("Bear");
        data.addAll(newList);
        listOfOperatingSystems.setAdapter(stringArrayAdapter);
    }
}
