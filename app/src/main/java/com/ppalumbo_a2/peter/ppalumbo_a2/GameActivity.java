package com.ppalumbo_a2.peter.ppalumbo_a2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by peter on 2/4/16.
 */
public class GameActivity extends AppCompatActivity {

    public static final String TAG = "GameActivity.java";
    public static final String PLAYER1_SCORE = "player1Score";
    public static final String PLAYER2_SCORE = "player2Score";
    public static final String GAMES_PLAYED = "gamesPlayed";
    public static final String GAME_OVER = "gameOver";
    public static final String BUTTONS ="buttonArray";

//    private RadioButton mOnePlayer = (RadioButton)findViewById(R.id.onePlayer_radio);
//    private RadioButton mTwoPlayer = (RadioButton)findViewById(R.id.twoPlayer_radio);
//    private RadioButton mXFirst = (RadioButton)findViewById(R.id.xFirst_radio);
//    private RadioButton mOFirst = (RadioButton)findViewById(R.id.oFirst_radio);
//    private RadioButton mAndroid = (RadioButton)findViewById(R.id.android_radio);
//    private RadioButton mApple =(RadioButton)findViewById(R.id.apple_radio);


    //game board
    private ImageButton mSquare1;
    private ImageButton mSquare2;
    private ImageButton mSquare3;
    private ImageButton mSquare4;
    private ImageButton mSquare5;
    private ImageButton mSquare6;
    private ImageButton mSquare7;
    private ImageButton mSquare8;
    private ImageButton mSquare9;

    //Textviews
    private TextView mGames;
    private TextView mPlayer1Score;
    private TextView mPayer2Score;
    //Reset Button
    private Button mReset;

    //Saved Variables
    private int playerOption =1;
    //private int firstOption;
    //private int sideOption;
    private int gamesPlayed=0;
    private int scorePlayer1 =0;
    private int scorePlayer2 =0;
    private int player =0;

    //Booleans for buttons
    private int button1 = 0;
    private int button2 = 0;
    private int button3 = 0;
    private int button4 = 0;
    private int button5 = 0;
    private int button6 = 0;
    private int button7 = 0;
    private int button8 = 0;
    private int button9 = 0;
    private boolean winnerChosen = false;

    private int[] buttonArray;

    //TODO save variables for rotation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        setButtonArray();
        savedInstanceState.putInt(PLAYER1_SCORE, scorePlayer1);
        savedInstanceState.putInt(PLAYER2_SCORE, scorePlayer2);
        savedInstanceState.putInt(GAMES_PLAYED, gamesPlayed);
        savedInstanceState.putBoolean(GAME_OVER, winnerChosen);
        savedInstanceState.putIntArray(BUTTONS, buttonArray);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if(savedInstanceState!=null)
        {
            scorePlayer1 = savedInstanceState.getInt(PLAYER1_SCORE);
            scorePlayer2 = savedInstanceState.getInt(PLAYER2_SCORE);
            gamesPlayed = savedInstanceState.getInt(GAMES_PLAYED);
            winnerChosen = savedInstanceState.getBoolean(GAME_OVER);
            buttonArray = savedInstanceState.getIntArray(BUTTONS);
        }

        mSquare1 = (ImageButton)findViewById(R.id.board_button1);
        mSquare2 = (ImageButton)findViewById(R.id.board_button2);
        mSquare3 = (ImageButton)findViewById(R.id.board_button3);
        mSquare4 = (ImageButton)findViewById(R.id.board_button4);
        mSquare5 = (ImageButton)findViewById(R.id.board_button5);
        mSquare6 = (ImageButton)findViewById(R.id.board_button6);
        mSquare7 = (ImageButton)findViewById(R.id.board_button7);
        mSquare8 = (ImageButton)findViewById(R.id.board_button8);
        mSquare9 = (ImageButton)findViewById(R.id.board_button9);

        mGames = (TextView)findViewById(R.id.games_played_view);
        mPlayer1Score = (TextView)findViewById(R.id.player1_score_view);
        mPayer2Score = (TextView)findViewById(R.id.player2_score_view);

        mReset = (Button)findViewById(R.id.reset_button);
        //mSquare1.setBackgroundResource(R.drawable.ic_android_logo);
//        if(mOnePlayer.isChecked()){
//            Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
//        }
        if(buttonArray==null) {
            setButtonArray();
        }
        getButtonArrayButtons();
        updateScores();
        mSquare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button1, 1);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button2, 2);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button3, 3);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button4, 4);
                checkWinner1();
                checkWinner2();
            }
        });

        mSquare5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button5, 5);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button6, 6);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button7, 7);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button8, 8);
                checkWinner1();
                checkWinner2();
            }
        });
        mSquare9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMove(button9, 9);
                checkWinner1();
                checkWinner2();
            }
        });
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons();
            }
        });


    }



    public void setPlayer(){
        player++;
    }

    public int getPlayer(){
        return player;
    }


    public void checkWinner1(){
        if(button1 ==1 && button2 ==1 && button3==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button4 ==1 && button5 ==1 && button6==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button8 ==1 && button8 ==1 && button9==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button1 ==1 && button4 ==1 && button7==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button2 ==1 && button5 ==1 && button8 ==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button3 ==1 && button6 ==1 && button9 ==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button1 ==1 && button5 ==1 && button9 ==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }
        if(button3 ==1 && button5 ==1 && button7 ==1 && !winnerChosen){
            Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer1++;
            cantMove();
        }

    }

    public void cantMove(){
        winnerChosen = true;
    }

    public void checkWinner2(){
        if(button1 ==2 && button2 ==2 && button3==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button4 ==2 && button5 ==2 && button6==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button8 ==2 && button8 ==2 && button9==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
        }
        if(button1 ==2 && button4 ==2 && button7==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button2 ==2 && button5 ==2 && button8 ==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button3 ==2 && button6 ==2 && button9 ==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button1 ==2 && button5 ==2 && button9 ==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }
        if(button3 ==2 && button5 ==2 && button7 ==2 && !winnerChosen){
            Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_SHORT).show();
            scorePlayer2++;
            cantMove();
        }

    }

    public void canMove(int move, int rId){
        if(!checkDraw()){
            Toast.makeText(this, "It was a draw!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(move!=0 || winnerChosen){
            Toast.makeText(this, "You can't move there!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if(player%2==0){
                ImageButton tmp = getButton(rId);
                //tmp.setImageResource(R.drawable.ic_android_logo);
                tmp.setBackgroundResource(R.drawable.ic_android_logo);
                setButtonFirstPlayer(rId);
            }
            else if(playerOption == 1){
                computerMove();
            }
            else {
                ImageButton tmp = getButton(rId);
                //tmp.setImageResource(R.drawable.ic_apple_logo);
                tmp.setBackgroundResource(R.drawable.ic_apple_logo);
                setButtonSecondPlayer(rId);
            }
        }
        setPlayer();
    }
//TODO get computerMove working
    public void computerMove(){
        setButtonArray();
        int test = 0;
        for(int i = 0; i<buttonArray.length; i++){
            if(buttonArray[i]==0){
                test = i;
                break;
            }
        }
//        Random rand = new Random();
//        int random = 1 + rand.nextInt();
//        int button = getButtonValue(test);
//        boolean cpuGone = false;
//        while (!cpuGone) {
//            if (button == 0) {
                ImageButton tmp = getButton(test+1);
                tmp.setBackgroundResource(R.drawable.ic_apple_logo);
                setButtonSecondPlayer(test+1);
//                cpuGone = true;
//            } else {
//                random = 1 + (int)Math.random() * (9);
//                button = getButtonValue(random);
//            }
//        }
////        return;
    }
    public ImageButton getButton(int button){
        switch(button){
            case 1:
                return mSquare1;
            case 2:
                return mSquare2;
            case 3:
                return mSquare3;
            case 4:
                return mSquare4;
            case 5:
                return mSquare5;
            case 6:
                return mSquare6;
            case 7:
                return mSquare7;
            case 8:
                return mSquare8;
            case 9:
                return mSquare9;
        }
        return mSquare1;
    }
    public void setButtonFirstPlayer(int button){
        switch(button){
            case 1:
                button1 =1;
                break;
            case 2:
                button2 =1;
                break;
            case 3:
                button3 = 1;
                break;
            case 4:
                button4 =1;
                break;
            case 5:
                button5 =1;
                break;
            case 6:
                button6 =1;
                break;
            case 7:
                button7 =1;
                break;
            case 8:
                button8 =1;
                break;
            case 9:
                button9 =1;
                break;
        }

    }
    public void setButtonSecondPlayer(int button){
        switch(button){
            case 1:
                button1 =2;
                break;
            case 2:
                button2 =2;
                break;
            case 3:
                button3 =2;
                break;
            case 4:
                button4 =2;
                break;
            case 5:
                button5 =2;
                break;
            case 6:
                button6 =2;
                break;
            case 7:
                button7 =2;
                break;
            case 8:
                button8 =2;
                break;
            case 9:
                button9 =2;
                break;
        }

    }

    public int getButtonValue(int buttonNum){
        switch(buttonNum){
            case 1:
                return button1;
            case 2:
                return button2;
            case 3:
                return button3;
            case 4:
                return button4;
            case 5:
                return button5;
            case 6:
                return button6;
            case 7:
                return button7;
            case 8:
                return button8;
            case 9:
                return button9;
        }
        return buttonNum;
    }
    public void setButtonValue(int button, int buttonNum){
        switch(button){
            case 1:
                button1 =buttonNum;
                break;
            case 2:
                button2 =buttonNum;
                break;
            case 3:
                button3 =buttonNum;
                break;
            case 4:
                button4 =buttonNum;
                break;
            case 5:
                button5 =buttonNum;
                break;
            case 6:
                button6 =buttonNum;
                break;
            case 7:
                button7 =buttonNum;
                break;
            case 8:
                button8 =buttonNum;
                break;
            case 9:
                button9 =buttonNum;
                break;
        }
    }
    //TODO reset game

    public void resetButtons(){
        mSquare1.setBackgroundResource(android.R.drawable.btn_default);
        mSquare2.setBackgroundResource(android.R.drawable.btn_default);
        mSquare3.setBackgroundResource(android.R.drawable.btn_default);
        mSquare4.setBackgroundResource(android.R.drawable.btn_default);
        mSquare5.setBackgroundResource(android.R.drawable.btn_default);
        mSquare6.setBackgroundResource(android.R.drawable.btn_default);
        mSquare7.setBackgroundResource(android.R.drawable.btn_default);
        mSquare8.setBackgroundResource(android.R.drawable.btn_default);
        mSquare9.setBackgroundResource(android.R.drawable.btn_default);
        winnerChosen = false;
        button1=0;
        button2=0;
        button3=0;
        button4=0;
        button5=0;
        button6=0;
        button7=0;
        button8=0;
        button9=0;
        player=0;

        gamesPlayed++;
        updateScores();
    }

    private void updateScores(){
        mGames.setText(Integer.toString(gamesPlayed));
        mPlayer1Score.setText(Integer.toString(scorePlayer1));
        mPayer2Score.setText(Integer.toString(scorePlayer2));
    }
    private void setButtonArray(){
        buttonArray = new int[9];
        for(int i =0; i < buttonArray.length; i++ ){
            buttonArray[i] = getButtonValue(i+1);
        }
    }
    private void getButtonArrayButtons(){
        for(int i = 0; i < buttonArray.length; i++){
            setButtonValue(i+1, buttonArray[i]);
            setImage(i+1,buttonArray[i]);
        }
    }
    private void setImage(int button, int buttonValue){
        ImageButton tmp = getButton(button);
        switch (buttonValue){
            case 0:
                tmp.setBackgroundResource(android.R.drawable.btn_default);
                break;
            case 1:
                tmp.setBackgroundResource(R.drawable.ic_android_logo);
                break;
            case 2:
                tmp.setBackgroundResource(R.drawable.ic_apple_logo);
                break;
        }
    }
    private boolean checkDraw(){
        setButtonArray();
        boolean ans = false;
        for(int i = 0; i < buttonArray.length; i++){
            if(buttonArray[i]==0){
                ans = true;
                return ans;
            }
        }
        return ans;
    }
}
