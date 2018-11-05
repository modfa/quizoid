package com.example.ahad.quizoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TextView variables
    private TextView mScoreDisplayTextView;

    // RadioGroup Variables
    private RadioGroup mRadioGroupOne, mRadioGroupTwo, mRadioGroupThree;

    // Checkboxes variables
    private CheckBox mCheckBoxOne, mCheckBoxTwo, mCheckBoxThree;

    // EditText Variable
    private EditText mEditTextOne;

    // Final score variable
    private int mScore = 0;

    // helper score variables
    private int mScoreIcreaseByValue = 1;
    private int mZeroScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding the submit button view
        final Button mSubmitButton = findViewById(R.id.submit);

        // Setting up listener on the submit button
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finding the first radio group
                mRadioGroupOne = findViewById(R.id.radio_group_1);
                int questionOneId = mRadioGroupOne.getCheckedRadioButtonId();

                // finding the second radio group
                mRadioGroupTwo = findViewById(R.id.radio_group_2);
                int questionTwoId = mRadioGroupTwo.getCheckedRadioButtonId();

                // finding the third radio group
                mRadioGroupThree = findViewById(R.id.radio_group_3);
                int questionThreeId = mRadioGroupThree.getCheckedRadioButtonId();


                // finding the first checkbox
                mCheckBoxOne = findViewById(R.id.check_box_1);
                boolean checkBoxOne = mCheckBoxOne.isChecked();

                // finding the second checkbox
                mCheckBoxTwo = findViewById(R.id.check_box_2);
                boolean checkBoxTwo = mCheckBoxTwo.isChecked();

                // finding the third checkbox
                mCheckBoxThree = findViewById(R.id.check_box_3);
                boolean checkBoxThree = mCheckBoxThree.isChecked();

                // finding the edit text view
                mEditTextOne = findViewById(R.id.answer_edit_text);
                String edittextAnswer = mEditTextOne.getText().toString().trim();

                // Calling the calculateScore method to calculate the final scores
                calculateScore(questionOneId, questionTwoId, questionThreeId, edittextAnswer, checkBoxOne, checkBoxTwo, checkBoxThree);

                // Toast to display the final score and respective question's answers
                Toast.makeText(getApplication(), "You Scored : " + mScore + "\n"
                        + "Answer 1 - Brian Lara" + "\n"
                        + "Answer 2 - Brian Lara" + "\n"
                        + "Answer 3 - AB De Villers" + "\n"
                        + "Answer 4 - Don Bradman" + "\n"
                        + "Answer 5 - Gully and Silly point", Toast.LENGTH_SHORT).show();

                // Calling the method to set the score
                display(mScore);
                mScore =0;

            }
        });

        // finding the replay button
        Button mResetButton = findViewById(R.id.replay);

        // Setting up listener on the submit button
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = 0;
                mScoreDisplayTextView.setText(String.valueOf(mScore));

                // Calling the method to reset all the widgets
                resetWidgets();
            }
        });
    }


    /**
     * Calculates the Scores of the user.
     */
    private void calculateScore(int radioGrpOne, int radioGrpTwo, int radioGrpThree, String editTextAnswer, boolean checkBoxOne, boolean checkBoxTwo, boolean checkBoxThree) {
        if (radioGrpOne == R.id.brain_lara) {
            scoreIncrease(mScoreIcreaseByValue);
        } else {
            scoreIncrease(mZeroScore);
        }

        if (radioGrpTwo == R.id.rohit_sharma) {
            scoreIncrease(mScoreIcreaseByValue);
        } else {
            scoreIncrease(mZeroScore);
        }

        if (radioGrpThree == R.id.ab_devilliers) {
            scoreIncrease(mScoreIcreaseByValue);
        } else {
            scoreIncrease(mZeroScore);
        }

        if (editTextAnswer.equalsIgnoreCase(getString(R.string.don_bradman))) {
            scoreIncrease(mScoreIcreaseByValue);
        } else {
            scoreIncrease(mZeroScore);
        }

        if (checkBoxOne && checkBoxTwo && !checkBoxThree) {
            scoreIncrease(mScoreIcreaseByValue);
        } else {
            scoreIncrease(mZeroScore);
        }
    }

    // It increases the score for each correct answer by 1
    private void scoreIncrease(int current_score) {
        mScore += current_score;
    }

    //method to display the score on textview
    private void display(int score) {
        mScoreDisplayTextView = findViewById(R.id.scoreTextView);
        mScoreDisplayTextView.setText("" + score);
    }

    // Method to reset all the widgets
    private void resetWidgets() {
        mRadioGroupOne.clearCheck();
        mRadioGroupTwo.clearCheck();
        mRadioGroupThree.clearCheck();
        mCheckBoxOne.setChecked(false);
        mCheckBoxTwo.setChecked(false);
        mCheckBoxThree.setChecked(false);
        mEditTextOne.getText().clear();
    }

}
