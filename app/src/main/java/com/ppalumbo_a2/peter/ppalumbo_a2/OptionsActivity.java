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
    public static final String PLAYER_INDEX = "player";
    public static final String FIRST_INDEX = "first";
    public static final String SIDE_INDEX = "side";

    private Button mClearScore;
    private RadioGroup mPlayerGroup;
    private RadioGroup mWhoFirstGroup;
    private RadioGroup mOneSideGroup;

    private int playerIndex;
    private int firstIndex;
    private int sideIndex;

    //on Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        if (savedInstanceState != null) {
            playerIndex = savedInstanceState.getInt(PLAYER_INDEX, 0);
            firstIndex = savedInstanceState.getInt(FIRST_INDEX, 0);
            sideIndex = savedInstanceState.getInt(SIDE_INDEX, 0);
        } else {
        getValueResult();
        }

        mClearScore = (Button) findViewById(R.id.clearScore_button);

        checkRadio();




        mWhoFirstGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstIndex = mWhoFirstGroup.getCheckedRadioButtonId();
                setValueResult();

            }
        });
        mOneSideGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sideIndex = mOneSideGroup.getCheckedRadioButtonId();
                setValueResult();

            }
        });


        getValueResult();
        setValueResult();

    }

    //Check the radio buttons in the radio group when initialized
    public void checkRadio() {
        mPlayerGroup = (RadioGroup) findViewById(R.id.playerRadioGroup);
        mWhoFirstGroup = (RadioGroup) findViewById(R.id.firstPersonRadioGroup);
        mOneSideGroup = (RadioGroup) findViewById(R.id.sideRadioGroup);
        //Check em up
        //Player group
        if (playerIndex == 0) {
            mPlayerGroup.check(R.id.onePlayer_radio);
        } else if (playerIndex == 1) {
            mPlayerGroup.check(R.id.twoPlayer_radio);
        }
        //X vs O group
        if (firstIndex == 0) {
            mWhoFirstGroup.check(R.id.xFirst_radio);
        } else if (firstIndex == 1) {
            mWhoFirstGroup.check(R.id.oFirst_radio);
        }
        //Android vs Apple Group
        if (sideIndex == 0) {
            mOneSideGroup.check(R.id.android_radio);
        } else if (sideIndex == 1) {
            mOneSideGroup.check(R.id.apple_radio);
        }
    }

    //Save between rotations
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        setValueResult();
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(PLAYER_INDEX, playerIndex);
        savedInstanceState.putInt(FIRST_INDEX, firstIndex);
        savedInstanceState.putInt(SIDE_INDEX, sideIndex);

    }
    //TODO make this work!
    //Set values to intent received
    public void setValueResult() {
        Intent data = new Intent();
        data.putExtra(PLAYER_INDEX, playerIndex);
        data.putExtra(FIRST_INDEX, firstIndex);
        data.putExtra(SIDE_INDEX, sideIndex);
        setResult(RESULT_OK, data);
    }
    //Send intent values back to welcome
    public void getValueResult() {
        Intent data = getIntent();
        playerIndex = data.getIntExtra(WelcomeActivity.OPTION_PLAYER_INDEX, 1);
        firstIndex = data.getIntExtra(WelcomeActivity.OPTION_FIRST_INDEX, 0);
        sideIndex = data.getIntExtra(WelcomeActivity.OPTION_SIDE_INDEX, 0);
    }


    public void makeToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    public void onNumPlayerClicked(View v) {

        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {

            case R.id.onePlayer_radio:
                if (checked)
                    playerIndex = 1;
                break;
            case R.id.twoPlayer_radio:
                playerIndex = 0;
                break;
        }
        setValueResult();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}

