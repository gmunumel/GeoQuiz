package com.bignerdranch.android.geoquiz;

public class TrueFalse {
	private int mQuestion;
	
	private boolean mTrueQuestion;
	
	private boolean mIsCheater;
	
	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
		mIsCheater = false;
	}

	public boolean getIsCheater() {
		return mIsCheater;
	}

	public void setIsCheater(boolean isCheater) {
		mIsCheater = isCheater;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}

}
