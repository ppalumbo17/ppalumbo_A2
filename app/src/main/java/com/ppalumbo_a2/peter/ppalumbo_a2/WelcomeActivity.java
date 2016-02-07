package com.ppalumbo_a2.peter.ppalumbo_a2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class WelcomeActivity extends AppCompatActivity {

    public static final String TAG = "WelcomeActivity.java";
    public static final String PLAYER_INDEX = "player";
    public static final String FIRST_INDEX = "first";
    public static final String SIDE_INDEX = "side";

    private Button mNewGame;
    private Button mOptions;
    private Button mQuit;

    //Options Saves
    private int mOptionsPlayer;
    private int mOptionsFirst;
    private int mOptionsSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(savedInstanceState!=null){
            mOptionsPlayer=savedInstanceState.getInt(WelcomeActivity.PLAYER_INDEX, 0);
            mOptionsFirst=savedInstanceState.getInt(WelcomeActivity.FIRST_INDEX, 0);
            mOptionsSide=savedInstanceState.getInt(WelcomeActivity.SIDE_INDEX, 0);

        }
        mNewGame = (Button)findViewById(R.id.newGame_button);
        mOptions = (Button)findViewById(R.id.options_button);
        mQuit = (Button)findViewById(R.id.quit_button);

        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, GameActivity.class);
                i.putExtra(PLAYER_INDEX, mOptionsPlayer);
                i.putExtra(FIRST_INDEX, mOptionsFirst);
                i.putExtra(SIDE_INDEX, mOptionsSide);
                startActivityForResult(i,1);

            }
        });

        mOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, OptionsActivity.class);
                i.putExtra(PLAYER_INDEX, mOptionsPlayer);
                i.putExtra(FIRST_INDEX, mOptionsFirst);
                i.putExtra(SIDE_INDEX, mOptionsSide);

                startActivityForResult(i, 0);
            }
        });

        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(WelcomeActivity.PLAYER_INDEX, mOptionsPlayer);
        savedInstanceState.putInt(WelcomeActivity.FIRST_INDEX, mOptionsFirst);
        savedInstanceState.putInt(WelcomeActivity.SIDE_INDEX, mOptionsSide);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //super.onActivityResult(requestCode, resultCode, data);
        //if(resultCode==0) {
        if(data==null)
            return;
            mOptionsPlayer = data.getIntExtra(WelcomeActivity.PLAYER_INDEX, 0);
            mOptionsFirst = data.getIntExtra(WelcomeActivity.FIRST_INDEX, 0);
            mOptionsSide = data.getIntExtra(WelcomeActivity.SIDE_INDEX, 0);
        //}
    }



    //Logs
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
