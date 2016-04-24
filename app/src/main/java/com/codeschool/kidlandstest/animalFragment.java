package com.codeschool.kidlandstest;


import android.app.FragmentManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * Created by Bill on 17/04/2016.
 */
public class animalFragment extends Fragment{

    private MediaPlayer mediaPlayer;
    private int playbackPosition=0;
    ImageButton imgbtnLearn;
    ImageButton imgbtnBack;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //return inflater.inflate(R.layout.animal_layout,container,false);
        final View view  =   inflater.inflate(R.layout.animal_layout, container, false);
        imgbtnLearn = (ImageButton) view.findViewById(R.id.imgbtnLearn);
        imgbtnBack = (ImageButton) view.findViewById(R.id.imgbtnBack);
        imgbtnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imgbtnBack_onClick(v);
            }
        });
        return view;
    }



    private void imgbtnBack_onClick(View v)
    {
        getActivity().setContentView(R.layout.mainmenu_layout);
    }


}


