package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	// adding log TAG
	private static final String TAG = "QuizActivity";
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	
	// challenge #1
	private LinearLayout mMainLinearLayout;
	// challenge #2
	private Button mPreviousButton;
	// challenge #3
	private ImageButton mNextImageButton;
	private ImageButton mPreviousImageButton;

	private TrueFalse[] mQuestionBank = new TrueFalse[] {
        new TrueFalse(R.string.question_oceans, true),
        new TrueFalse(R.string.question_mideast, false),
        new TrueFalse(R.string.question_africa, false),
        new TrueFalse(R.string.question_americas, true),
        new TrueFalse(R.string.question_asia, true),
    };
    
    private int mCurrentIndex = 0;
    
    private void updateQuestion(){
    	int question = mQuestionBank[mCurrentIndex].getQuestion();
    	mQuestionTextView.setText(question);
    }
    
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        
        int messageResId = 0;
        
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show();
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);
        
        // adding the first question
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        
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
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length; 
                updateQuestion();
            }
        });
        
        // challenge #1
        // adding next question when view is pressed
        mMainLinearLayout = (LinearLayout)findViewById(R.id.main_linear_layout);
        mMainLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length; 
                updateQuestion();
            }
        });

        // challenge #2
        // previous button
        mPreviousButton = (Button)findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if (mCurrentIndex == 0) mCurrentIndex = 5;
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length; 
                updateQuestion();
            }
        });

        // challenge #3
        // adding image button for next and previous actions
        mNextImageButton = (ImageButton)findViewById(R.id.next_image_button);
        mNextImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length; 
                updateQuestion();
            }
        });

        mPreviousImageButton = (ImageButton)findViewById(R.id.previous_image_button);
        mPreviousImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if (mCurrentIndex == 0) mCurrentIndex = 5;
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length; 
                updateQuestion();
            }
        });
        
        
        updateQuestion();
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
}