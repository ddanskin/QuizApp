package com.danielledanskin.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int scoreOne = 0;
    int scoreTwo = 0;
    int scoreThree = 0;
    int scoreFour = 0;
    int scoreFive = 0;
    int scoreSix = 0;
    int scoreSeven = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method adds up the user's scores for each question and updates the score TextView */
    public void getScore(View view) {
        scoreQuestionSix();
        scoreQuestionSeven();
        int score = scoreOne + scoreTwo + scoreThree + scoreFour + scoreFive
                + scoreSix + scoreSeven;
        String scoreMessage = getString(R.string.your_score) + " " + Integer.toString(score);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView scoreTextView = (TextView) layout.findViewById(R.id.score_text);
        scoreTextView.setText(scoreMessage);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    /*
     * This method updates the scoreOne variable when the user clicks on a radio button in the
     * question's radio button group.
     */
    public void scoreQuestionOne(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q1_option4) {
            scoreOne = 1;
        } else {
            scoreOne = 0;
        }

    }

    /*
     * This method updates the scoreTwo variable when the user clicks on a radio button in the
     * question's radio button group.
     */
    public void scoreQuestionTwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q2_option2) {
            scoreTwo = 1;
        } else {
            scoreTwo = 0;
        }
    }

    /*
     * This method updates the scoreThree variable when the user clicks on a radio button in the
     * question's radio button group.
     */
    public void scoreQuestionThree(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String logMessage = "scoreQuestionThree " + Integer.toString(view.getId());
        Log.v("MainActivity", logMessage);
        // Check which radio button was clicked
        if (view.getId() == R.id.q3_option2) {
            scoreThree = 1;
        } else {
            scoreThree = 0;
        }
    }

    /*
     * This method updates the scoreFour variable when the user clicks on a radio button in the
     * question's radio button group.
     */
    public void scoreQuestionFour(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q4_option3) {
            scoreFour = 1;
        } else {
            scoreFour = 0;
        }
    }

    /*
     * This method updates the scoreFive variable when the user clicks on a radio button in the
     * question's radio button group.
     */
    public void scoreQuestionFive(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.q5_option1) {
            scoreFive = 1;
        } else {
            scoreFive = 0;
        }
    }
    /*
     * This method updates the scoreSix variable. If the appropriate boxes are checked, the score
     * will be 1, otherwise the score is 0.
     */
    private void scoreQuestionSix() {
        CheckBox answer1 = (CheckBox) findViewById(R.id.q6_checkbox1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.q6_checkbox2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.q6_checkbox3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.q6_checkbox4);

        if ( answer1.isChecked() && answer3.isChecked()
                && !answer2.isChecked() && !answer4.isChecked() ) {
            scoreSix = 1;
        } else {
            scoreSix = 0;
        }
    }

    /*
     * This method updates the scoreSeven variable. If the user input the full correct answer,
     * the score will be 2, otherwise if they get it mostly correct they will receive 1 point.
     * If they are completely wrong, the score will be 0.
     */
    private void scoreQuestionSeven() {
        EditText userInput = (EditText) findViewById(R.id.q7_user_input);
        String userText = userInput.getText().toString().toLowerCase();
        String correctAnswer = getString(R.string.blue_whale);
        String partialCorrectAnswer = getString(R.string.whale).toLowerCase();

        if (userText.equals(correctAnswer)) {
            scoreSeven = 2;
        } else if (userText.equals(partialCorrectAnswer)) {
            scoreSeven = 1;
        } else {
            scoreSeven = 0;
        }

    }
}
