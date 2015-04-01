package edu.feicui.assistant.main;

import android.app.Activity;
import android.os.Bundle;
import edu.feicui.assistant.util.LogWrapper;

/**
 * BaseActivity不需要注册，防止被打开？？？？？
 */
public class BaseActivity extends Activity {

	// protected final String TAG =
	// this.getClass().getName();// 获取完整类名

	protected final String TAG = this.getClass().getSimpleName();// 获取类名

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogWrapper.d(TAG, "onCreate");
		// 自定义异常
		throw new RuntimeException();
	}

	@Override
	protected void onStart() {
		super.onStart();
		LogWrapper.d(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		LogWrapper.d(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		LogWrapper.d(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		LogWrapper.d(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		LogWrapper.d(TAG, "onRestart");
	}

	@Override
	protected void onDestroy() {
		LogWrapper.d(TAG, "onDestroy");
		super.onDestroy();
	}
}
