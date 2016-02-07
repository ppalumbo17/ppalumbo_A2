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

    private int mPlayerIndex;
    private int mFirstIndex;
    private int mSideIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        if(savedInstanceState!=null){
            mPlayerIndex=savedInstanceState.getInt(WelcomeActivity.PLAYER_INDEX, 0);
            mFirstIndex=savedInstanceState.getInt(WelcomeActivity.FIRST_INDEX,0);
            mSideIndex=savedInstanceState.getInt(WelcomeActivity.SIDE_INDEX,0);
        }
        else{
            getValueResult();
        }

        mClearScore = (Button)findViewById(R.id.clearScore_button);
        mPlayerGroup = (RadioGroup)findViewById(R.id.playerRadioGroup);
        mWhoFirstGroup = (RadioGroup)findViewById(R.id.firstPersonRadioGroup);
        mOneSideGroup = (RadioGroup)findViewById(R.id.sideRadioGroup);

        //Check em up
        if(mPlayerIndex == 0) {
            mPlayerGroup.check(R.id.onePlayer_radio);
        }
        else //if(mPlayerIndex ==1)
            mPlayerGroup.check(R.id.twoPlayer_radio);
//        mWhoFirstGroup.check(R.id.onePlayer_radio);
        mPlayerGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton)v).isChecked();
                switch(v.getId()){

                    case R.id.onePlayer_radio:
                        if(checked)
                        mPlayerIndex=0;
                        break;
                    case R.id.twoPlayer_radio:
                        mPlayerIndex=1;
                        break;
                }
                setValueResult();
            }
        });

        mWhoFirstGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstIndex = mWhoFirstGroup.getCheckedRadioButtonId();
                setValueResult();
//                String tmp = Integer.toString(mPlayerGroup.getCheckedRadioButtonId());
//                makeToast(tmp);
            }
        });
        mOneSideGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSideIndex = mOneSideGroup.getCheckedRadioButtonId();
                setValueResult();
//                String tmp = Integer.toString(mPlayerGroup.getCheckedRadioButtonId());
//                makeToast(tmp);
            }
        });


        getValueResult();
        setValueResult();

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        setValueResult();
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(WelcomeActivity.PLAYER_INDEX, mPlayerIndex);
        savedInstanceState.putInt(WelcomeActivity.FIRST_INDEX, mFirstIndex);
        savedInstanceState.putInt(WelcomeActivity.SIDE_INDEX, mSideIndex);

    }


    public void setValueResult(){
        Intent data = new Intent();
        data.putExtra(WelcomeActivity.PLAYER_INDEX, mPlayerIndex);
        data.putExtra(WelcomeActivity.FIRST_INDEX, mFirstIndex);
        data.putExtra(WelcomeActivity.SIDE_INDEX, mSideIndex);
        setResult(RESULT_OK, data);
    }

    public void getValueResult(){
        Intent data = getIntent();
        mPlayerIndex = data.getIntExtra(WelcomeActivity.PLAYER_INDEX, 0);
        mFirstIndex = data.getIntExtra(WelcomeActivity.FIRST_INDEX, 0);
        mSideIndex = data.getIntExtra(WelcomeActivity.SIDE_INDEX, 0);
    }
    public void makeToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
