package com.example.arsalanhaider.bignerd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

    private  String classNameTag = "QuizActivity";

    Button mTrueButton;
    Button mFalseButton;
    ImageButton mNextButton;
    ImageButton mPreviousButton;

    TextView mQuestionTextView;
    
    TrueFalse[] mAnswerKey = new TrueFalse[] {
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true)
    };
    
    int mCurrentIndex = 0;
    
    private void updateQuestion() {
        int question = mAnswerKey[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }
    
    private void checkAnswer(boolean userPressedTrue) {

        boolean answerIsTrue = mAnswerKey[mCurrentIndex].isTrueQuestion();
        
        int messageResId = 0;
        
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        //set text to first question in array

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mAnswerKey.length;
                updateQuestion();
            }
        });

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);		
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mAnswerKey.length; 
                updateQuestion();
            }
        });

        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        updateQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Utils.logMessage(classNameTag , "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.logMessage(classNameTag , "OnResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Utils.logMessage(classNameTag , "OnPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.logMessage(classNameTag , "OnStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.logMessage(classNameTag , "OnDestroy");

    }
}
