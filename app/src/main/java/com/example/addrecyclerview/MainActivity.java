package com.example.addrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> values;
    private ArrayList<ItemData> itemValues;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    private EditText name;
    private EditText no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        name=findViewById(R.id.name);
        no=findViewById(R.id.no);

        values=new ArrayList<>();
        for(int i=1; i<=10; i++) {
            values.add("Item Data - "+1);
        }

        itemValues=new ArrayList<>();
        for (int i=1; i<=0; i++) {
            ItemData item=new ItemData();
            item.title="Title Data - "+i;
            item.subtitle="Subtitle Data - "+i;
            itemValues.add(item);
        }

        itemAdapter=new ItemAdapter(this, itemValues);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

    }

    public void addData(View view) {
        ItemData item=new ItemData();
        item.title=name.getText().toString();
        item.subtitle=no.getText().toString();

        itemValues.add(item);
        name.setText("");
        no.setText("");
        itemAdapter.notifyDataSetChanged();
    }
}

