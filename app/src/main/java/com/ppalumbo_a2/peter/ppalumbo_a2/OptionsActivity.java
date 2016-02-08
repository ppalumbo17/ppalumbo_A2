package com.ppalumbo_a2.peter.ppalumbo_a2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by peter on 2/4/16.
 */
public class OptionsActivity extends AppCompatActivity {

    public static final String TAG = "OptionsActivity.java";
//    public static final String PLAYER_INDEX = "player";
//    public static final String FIRST_INDEX = "first";
//    public static final String SIDE_INDEX = "side";

    private Button mClearScore;
    private RadioGroup mPlayerGroup;
    private RadioGroup mWhoFirstGroup;
    private RadioGroup mOneSideGroup;

    private int playerIndex;
    private int firstIndex;
    private int sideIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        if (savedInstanceState != null) {
            playerIndex = savedInstanceState.getInt(WelcomeActivity.PLAYER_INDEX, 0);
            firstIndex = savedInstanceState.getInt(WelcomeActivity.FIRST_INDEX, 0);
            sideIndex = savedInstanceState.getInt(WelcomeActivity.SIDE_INDEX, 0);
        } //else {
            getValueResult();
        //}

        mClearScore = (Button) findViewById(R.id.clearScore_button);

        checkRadio();

//        mWhoFirstGroup.check(R.id.onePlayer_radio);


        mWhoFirstGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstIndex = mWhoFirstGroup.getCheckedRadioButtonId();
                setValueResult();
//                String tmp = Integer.toString(mPlayerGroup.getCheckedRadioButtonId());
//                makeToast(tmp);
            }
        });
        mOneSideGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sideIndex = mOneSideGroup.getCheckedRadioButtonId();
                setValueResult();
//                String tmp = Integer.toString(mPlayerGroup.getCheckedRadioButtonId());
//                makeToast(tmp);
            }
        });


        getValueResult();
        setValueResult();

    }

    public void checkRadio(){
        mPlayerGroup = (RadioGroup) findViewById(R.id.playerRadioGroup);
        mWhoFirstGroup = (RadioGroup) findViewById(R.id.firstPersonRadioGroup);
        mOneSideGroup = (RadioGroup) findViewById(R.id.sideRadioGroup);
        //Check em up
        //Player group
        if (playerIndex == 0) {
            mPlayerGroup.check(R.id.onePlayer_radio);
        } else if(playerIndex ==1){
            mPlayerGroup.check(R.id.twoPlayer_radio);
        }
        //X vs O group
        if (firstIndex == 0)
        {
            mWhoFirstGroup.check(R.id.xFirst_radio);
        }
        else if(firstIndex ==1){
            mWhoFirstGroup.check(R.id.oFirst_radio);
        }
        //Android vs Apple Group
        if (sideIndex == 0)
        {
            mOneSideGroup.check(R.id.android_radio);
        }
        else if(sideIndex ==1){
            mOneSideGroup.check(R.id.apple_radio);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        setValueResult();
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(WelcomeActivity.PLAYER_INDEX, playerIndex);
        savedInstanceState.putInt(WelcomeActivity.FIRST_INDEX, firstIndex);
        savedInstanceState.putInt(WelcomeActivity.SIDE_INDEX, sideIndex);

    }


    public void setValueResult(){
        Intent data = new Intent();
        data.putExtra(WelcomeActivity.PLAYER_INDEX, playerIndex);
        data.putExtra(WelcomeActivity.FIRST_INDEX, firstIndex);
        data.putExtra(WelcomeActivity.SIDE_INDEX, sideIndex);
        setResult(RESULT_OK, data);
    }

    public void getValueResult(){
        Intent data = getIntent();
        playerIndex = data.getIntExtra(WelcomeActivity.PLAYER_INDEX, 0);
        firstIndex = data.getIntExtra(WelcomeActivity.FIRST_INDEX, 0);
        sideIndex = data.getIntExtra(WelcomeActivity.SIDE_INDEX, 0);
    }
    public void makeToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    public void onNumPlayerClicked(View v){

                boolean checked = ((RadioButton)v).isChecked();
                switch(v.getId()){

                    case R.id.onePlayer_radio:
                        if(checked)
                            playerIndex =0;
                        break;
                    case R.id.twoPlayer_radio:
                        playerIndex =1;
                        break;
                }
                setValueResult();
            }

    }

