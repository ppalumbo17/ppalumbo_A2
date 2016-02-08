package com.ppalumbo_a2.peter.ppalumbo_a2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    //Svae Tags
    public static final String TAG = "WelcomeActivity.java";
    public static final String OPTION_PLAYER_INDEX = "player";
    public static final String OPTION_FIRST_INDEX = "first";
    public static final String OPTION_SIDE_INDEX = "side";
    public static final String GAME_PLAYED = "gamesPlayed";
    public static final String GAME_SCORE1 = "scoreplayer1";
    public static final String GAME_SCORE2 = "scorePlayer2";

    //Buttons
    private Button mNewGame;
    private Button mOptions;
    private Button mQuit;

    //Options Saves
    private int optionsPlayer =1;
    private int optionsFirst =0;
    private int optionsSide =0;
    private int gamesPlayed =0;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    //On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(savedInstanceState!=null){
            optionsPlayer =savedInstanceState.getInt(OPTION_PLAYER_INDEX, 0);
            optionsFirst =savedInstanceState.getInt(OPTION_FIRST_INDEX, 0);
            optionsSide =savedInstanceState.getInt(OPTION_SIDE_INDEX, 0);

        }
        mNewGame = (Button)findViewById(R.id.newGame_button);
        mOptions = (Button)findViewById(R.id.options_button);
        mQuit = (Button)findViewById(R.id.quit_button);

        //On Click for new game button
        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(WelcomeActivity.this, GameActivity.class);
                p.putExtra(OPTION_PLAYER_INDEX, optionsPlayer);
                p.putExtra(OPTION_FIRST_INDEX, optionsFirst);
                p.putExtra(OPTION_SIDE_INDEX, optionsSide);
                p.putExtra(GAME_PLAYED, gamesPlayed);
                p.putExtra(GAME_SCORE1, scorePlayer1);
                p.putExtra((GAME_SCORE2),scorePlayer2);
                startActivityForResult(p, 0);
                //onActivityResult(0,1,i);

            }
        });
        //On Click for options
        mOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, OptionsActivity.class);
                i.putExtra(OPTION_PLAYER_INDEX, optionsPlayer);
                i.putExtra(OPTION_FIRST_INDEX, optionsFirst);
                i.putExtra(OPTION_SIDE_INDEX, optionsSide);
                startActivityForResult(i, 0);
                //onActivityResult(0, 1, i);
            }
        });

        //On Click for Quit Button
        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });



    }

    //TODO MAKE THIS WORK!
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(OPTION_PLAYER_INDEX, optionsPlayer);
        savedInstanceState.putInt(OPTION_FIRST_INDEX, optionsFirst);
        savedInstanceState.putInt(OPTION_SIDE_INDEX, optionsSide);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //super.onActivityResult(requestCode, resultCode, data);
        //if(resultCode==0) {
        if(data==null) {
            return;
        }
            optionsPlayer = data.getIntExtra(OptionsActivity.PLAYER_INDEX,0);
            optionsFirst = data.getIntExtra(OPTION_FIRST_INDEX,0);
            optionsSide = data.getIntExtra(OPTION_SIDE_INDEX, 0);
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
