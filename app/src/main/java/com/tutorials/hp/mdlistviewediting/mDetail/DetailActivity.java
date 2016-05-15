package com.tutorials.hp.mdlistviewediting.mDetail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutorials.hp.mdlistviewediting.R;
import com.tutorials.hp.mdlistviewediting.mData.CRUD;
import com.tutorials.hp.mdlistviewediting.mData.SacecraftCollection;
import com.tutorials.hp.mdlistviewediting.mData.Spacecraft;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt,descTxt;
    String name,desc;
    int position;
    EditText nameEditDetailTxt,descEditTextDetail;
    Button updateBtn,deleteBtn;
    CRUD crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        crud=new CRUD(SacecraftCollection.getSpacecrafts());

        nameTxt= (TextView) findViewById(R.id.nameTxtDetail);
        descTxt= (TextView) findViewById(R.id.descDetailTxt);

        //RECEIVE DATA
        Intent i=this.getIntent();
        name=i.getExtras().getString("NAME_KEY");
        desc=i.getExtras().getString("DESC_KEY");
        position=i.getExtras().getInt("POS_KEY");

        //BIND
        nameTxt.setText(name);
        descTxt.setText(desc);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayUpdateDialog();
            }
        });


    }

    //ADD DATA
    //SHOW DIALOG
    private void displayUpdateDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("UPDATE/DELETE DATA");
        d.setContentView(R.layout.dialog_layout);

        nameEditDetailTxt= (EditText) d.findViewById(R.id.nameEditTxt);
        descEditTextDetail= (EditText) d.findViewById(R.id.descEditTxt);
        updateBtn= (Button) d.findViewById(R.id.saveBtn);
        deleteBtn= (Button) d.findViewById(R.id.deleteBtn);

        nameEditDetailTxt.setText(name);
        descEditTextDetail.setText(desc);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spacecraft s=new Spacecraft();

                name=nameEditDetailTxt.getText().toString();
                desc=descEditTextDetail.getText().toString();

                s.setName(name);
                s.setDescription(desc);

                if(crud.update(position,s))
                {
                    nameEditDetailTxt.setText(name);
                    descEditTextDetail.setText(desc);

                    nameTxt.setText(name);
                    descTxt.setText(desc);
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(crud.delete(position))
                {
                    //KILL THIS ACTIVITY AND GO BACK TO MASTER
                    DetailActivity.this.finish();

                }
            }
        });

        d.show();

    }

}
