package com.example.gamescore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        TextView textViewTeam1Score = findViewById(R.id.textViewTeam1Score);
        TextView textViewTeam2Score = findViewById(R.id.textViewTeam2Score);

        textViewTeam1Score.setText(String.valueOf(score1));
        textViewTeam2Score.setText(String.valueOf(score2));

        textViewTeam1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1++;
                textViewTeam1Score.setText(String.valueOf(score1));
            }
        });
        textViewTeam2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTeam2Score.setText(String.valueOf(++score2));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }
}