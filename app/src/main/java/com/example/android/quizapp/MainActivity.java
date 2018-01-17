package com.example.android.quizapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables corresponding to the views.
    RadioGroup mQ1Answers;
    RadioButton mQ1Ans1, mQ1Ans2, mQ1Ans3, mQ1Ans4;
    EditText mQ2Answer;
    CheckBox mQ3Ans1, mQ3Ans2, mQ3Ans3, mQ3Ans4, mQ3Ans5;
    RadioGroup mQ4Answers;
    RadioButton mQ4Ans1, mQ4Ans2, mQ4Ans3, mQ4Ans4;
    RadioGroup mQ5Answers;
    RadioButton mQ5Ans1, mQ5Ans2, mQ5Ans3, mQ5Ans4;
    Button mSubmit, mReset;

    //Drawables used.
    Drawable imgRight, imgWrong;

    //Saves the score.
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQ1Answers = findViewById(R.id.q1_answers);
        mQ1Ans1 = findViewById(R.id.q1_ans1);
        mQ1Ans2 = findViewById(R.id.q1_ans2);
        mQ1Ans3 = findViewById(R.id.q1_ans3);
        mQ1Ans4 = findViewById(R.id.q1_ans4);
        mQ2Answer = findViewById(R.id.q2_answer);
        mQ3Ans1 = findViewById(R.id.q3_ans1);
        mQ3Ans2 = findViewById(R.id.q3_ans2);
        mQ3Ans3 = findViewById(R.id.q3_ans3);
        mQ3Ans4 = findViewById(R.id.q3_ans4);
        mQ3Ans5 = findViewById(R.id.q3_ans5);
        mQ4Answers = findViewById(R.id.q4_answers);
        mQ4Ans1 = findViewById(R.id.q4_ans1);
        mQ4Ans2 = findViewById(R.id.q4_ans2);
        mQ4Ans3 = findViewById(R.id.q4_ans3);
        mQ4Ans4 = findViewById(R.id.q4_ans4);
        mQ5Answers = findViewById(R.id.q5_answers);
        mQ5Ans1 = findViewById(R.id.q5_ans1);
        mQ5Ans2 = findViewById(R.id.q5_ans2);
        mQ5Ans3 = findViewById(R.id.q5_ans3);
        mQ5Ans4 = findViewById(R.id.q5_ans4);

        mSubmit = findViewById(R.id.submit);
        mReset = findViewById(R.id.reset);

        imgRight = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
        imgWrong = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);

        mSubmit.setOnClickListener(this);
        mReset.setOnClickListener(this);

        score = 0;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case(R.id.submit): {
                submitAnswer();
                break;
            }
            case(R.id.reset): {
                resetQuiz();
                break;
            }
        }
    }

    /**
     * Method called when the submit button is clicked.
     * Adds points to the score and displays the result.
     */
    private void submitAnswer() {
        //Actions for the first question.
        if (mQ1Ans1.isChecked()) {
            score += 1;
            mQ1Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        } else if (mQ1Ans2.isChecked()) {
            mQ1Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ1Ans3.isChecked()) {
            mQ1Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ1Ans4.isChecked()) {
            mQ1Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        }

        //Actions for the second question.
        if (mQ2Answer.getText().toString().equalsIgnoreCase(getString(R.string.q2_answer))) {
            score += 1;
            mQ2Answer.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        } else if (!mQ2Answer.getText().toString().equalsIgnoreCase(getString(R.string.q2_answer))){
            mQ2Answer.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        }

        //Actions for the third question.
        if (mQ3Ans1.isChecked() && !mQ3Ans2.isChecked() && !mQ3Ans3.isChecked()
                && mQ3Ans4.isChecked() && mQ3Ans5.isChecked()) {
            score += 1;
        }
        if (mQ3Ans1.isChecked()) {
            mQ3Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        }
        if (mQ3Ans2.isChecked()) {
            mQ3Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        }
        if (mQ3Ans3.isChecked()) {
            mQ3Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        }
        if (mQ3Ans4.isChecked()) {
            mQ3Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        }
        if (mQ3Ans5.isChecked()) {
            mQ3Ans5.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        }

        //Actions for the fourth question.
        if (mQ4Ans1.isChecked()){
            mQ4Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ4Ans2.isChecked()) {
            score += 1;
            mQ4Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        } else if (mQ4Ans3.isChecked()) {
            mQ4Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ4Ans4.isChecked()) {
            mQ4Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);

        }

        //Actions for the fifth question.
        if (mQ5Ans1.isChecked()) {
            mQ5Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ5Ans2.isChecked()) {
            mQ5Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ5Ans3.isChecked()) {
            mQ5Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgWrong, null);
        } else if (mQ5Ans4.isChecked()) {
            score += 1;
            mQ5Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgRight, null);
        }

        //Displays the score when submitted.
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        String message = "";
        if (score == 5){
            message += getString(R.string.perfect, String.valueOf(score));
        } else if (score < 5 && score > 0) {
            message += getString(R.string.notBad, String.valueOf(score));
        } else if (score == 0) {
            message += getString(R.string.tryAgain);
        }
        dialog.setMessage(message);
        AlertDialog alert = dialog.create();
        alert.show();

        mSubmit.setClickable(false);
        mReset.setClickable(true);
    }

    /**
     * Method called when the reset button is called.
     */
    private void resetQuiz() {
        //Resets the score.
        score = 0;

        //Resets the verification icons.
        mQ1Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ1Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ1Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ1Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ2Answer.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ3Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ3Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ3Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ3Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ3Ans5.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ4Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ4Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ4Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ4Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ5Ans1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ5Ans2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ5Ans3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mQ5Ans4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        //Resets all the answers.
        mQ1Answers.clearCheck();
        mQ2Answer.setText(null);
        mQ3Ans1.setChecked(false);
        mQ3Ans2.setChecked(false);
        mQ3Ans3.setChecked(false);
        mQ3Ans4.setChecked(false);
        mQ3Ans5.setChecked(false);
        mQ4Answers.clearCheck();
        mQ5Answers.clearCheck();

        mSubmit.setClickable(true);
        mReset.setClickable(false);
    }
}
