package com.danielledanskin.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreOne = 0;
    int scoreTwo = 0;
    int scoreThree = 0;
    int scoreFour = 0;
    int scoreFive = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getScore(View view) {
        int score = scoreOne + scoreTwo + scoreThree + scoreFour + scoreFive;
        TextView scoreTextView = (TextView) findViewById(R.id.score_text);
        String scoreMessage = getString(R.string.get_score) + Integer.toString(score);
        scoreTextView.setText(scoreMessage);
    }

    public void scoreQuestionOne(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q1_option4) {
               scoreOne = 1;
        }

    }

    public void scoreQuestionTwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q2_option2) {
            scoreTwo = 1;
        }
    }

    public void scoreQuestionThree(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q3_option2) {
            scoreTwo = 1;
        }
    }

    public void scoreQuestionFour(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q4_option3) {
            scoreTwo = 1;
        }
    }

    public void scoreQuestionFive(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q5_option1) {
            scoreTwo = 1;
        }
    }
}
