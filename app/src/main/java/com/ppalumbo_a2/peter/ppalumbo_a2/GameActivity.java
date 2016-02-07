package com.ppalumbo_a2.peter.ppalumbo_a2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by peter on 2/4/16.
 */
public class GameActivity extends AppCompatActivity {

    public static final String TAG = "GameActivity.java";

//    private RadioButton mOnePlayer = (RadioButton)findViewById(R.id.onePlayer_radio);
//    private RadioButton mTwoPlayer = (RadioButton)findViewById(R.id.twoPlayer_radio);
//    private RadioButton mXFirst = (RadioButton)findViewById(R.id.xFirst_radio);
//    private RadioButton mOFirst = (RadioButton)findViewById(R.id.oFirst_radio);
//    private RadioButton mAndroid = (RadioButton)findViewById(R.id.android_radio);
//    private RadioButton mApple =(RadioButton)findViewById(R.id.apple_radio);

    private int player =0;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        if(mOnePlayer.isChecked()){
//            Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
//        }

        if(savedInstanceState!=null)
        {

        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
    public void setPlayer(){
        player++;
    }

    public int getPlayer(){
        return player;
    }

}
