package com.example.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements GameOverListener {

    private GameView mGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mGameView = (GameView)findViewById(R.id.gameview);
        mGameView.setOnGameOverListener(this);
    }

    @Override
    public void GameOver() {
        finish();
    }
}