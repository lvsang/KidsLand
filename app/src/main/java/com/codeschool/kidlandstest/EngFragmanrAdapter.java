package com.codeschool.kidlandstest;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bill on 17/04/2016.
 */
public class EngFragmanrAdapter extends FragmentPagerAdapter{

    public EngFragmanrAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int arg0){
        switch (arg0){
            case 0:
                return new animalFragment();
            case 1:
                return new jobsFragment();
            case 2:
                return new natureVehicle();
            case 3:
                return new vehicleFragment();
            default:
                break;
        }
        return null;
    }

    public int getCount()
    {
        return 4;

    }
}
