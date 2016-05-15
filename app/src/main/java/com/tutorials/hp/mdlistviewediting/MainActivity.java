package com.tutorials.hp.mdlistviewediting;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.tutorials.hp.mdlistviewediting.mData.CRUD;
import com.tutorials.hp.mdlistviewediting.mData.SacecraftCollection;
import com.tutorials.hp.mdlistviewediting.mData.Spacecraft;
import com.tutorials.hp.mdlistviewediting.mListView.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText nameEditText,descEditText;
    Button saveBtn;
    CustomAdapter adapter;
    CRUD crud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        lv= (ListView) findViewById(R.id.lv);
        crud=new CRUD(SacecraftCollection.getSpacecrafts());
        adapter=new CustomAdapter(this,crud.getSpacecrafts());

//        lv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDialog();
            }
        });

    }

    //ADD DATA
    //SHOW DIALOG
    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("ADD DATA");
        d.setContentView(R.layout.dialog_layout);

        nameEditText= (EditText) d.findViewById(R.id.nameEditTxt);
        descEditText= (EditText) d.findViewById(R.id.descEditTxt);
        saveBtn= (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spacecraft s=new Spacecraft();
                s.setName(nameEditText.getText().toString());
                s.setDescription(descEditText.getText().toString());

                if(crud.addNew(s))
                {
                    nameEditText.setText("");
                    descEditText.setText("");

                    lv.setAdapter(adapter);

                }
            }
        });

        d.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        lv.setAdapter(adapter);
    }
}










