package com.tutorials.hp.mdlistviewediting.mListView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tutorials.hp.mdlistviewediting.R;
import com.tutorials.hp.mdlistviewediting.mData.Spacecraft;
import com.tutorials.hp.mdlistviewediting.mDetail.DetailActivity;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/14/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Spacecraft> spacecrafts;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;

        //INITIALIZE INFLATER
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);

        final String name=spacecrafts.get(position).getName();
        final String desc=spacecrafts.get(position).getDescription();

        //BIND
        nameTxt.setText(name);
        descTxt.setText(desc);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(name,desc,position);
            }
        });
        return convertView;
    }

    //OPNE NEW ACTIVITY
    private void openDetailActivity(String name,String desc,int pos)
    {
        Intent i=new Intent(c, DetailActivity.class);

        //PACK DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("DESC_KEY",desc);
        i.putExtra("POS_KEY",pos);

        //SEND AND OPEN ACTIVITY
        c.startActivity(i);

    }
}
















