package com.tutorials.hp.mdlistviewediting.mData;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/14/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CRUD {

    ArrayList<Spacecraft> spacecrafts;

    public CRUD(ArrayList<Spacecraft> spacecrafts) {
        this.spacecrafts = spacecrafts;
    }

    //ADD
    public boolean addNew(Spacecraft spacecraft)
    {
        try {
            spacecrafts.add(spacecraft);

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    //RETRIEVE
    public ArrayList<Spacecraft> getSpacecrafts()
    {
        return spacecrafts;
    }

    //UPDATE
    public boolean update(int pos,Spacecraft newSpacecraft)
    {
        try {
            spacecrafts.remove(pos);
            spacecrafts.add(pos,newSpacecraft);

            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    //DELETE
    public boolean delete(int pos)
    {
        try {

            spacecrafts.remove(pos);

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
