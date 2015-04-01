/*
 * @(#): CrashHandler.java
 * @project: 手机助手
 * @version: 1.0
 * @copyright: Copyright (C) 2013-2014 
 * @description: 
 * 
 * @modify:
 * ---- No.1 Modified By android At 2014-5-9 下午3:58:35 Based On v0 ----
 *      Create file
 */

package edu.feicui.assistant.util;

import java.lang.Thread.UncaughtExceptionHandler;

import android.util.Log;

/**
 * 一步：实现UncaughtExceptionHandler（用来处理没有被try..catch。。处理的异常）<br>
 * 二步：重写uncaughtException（）方法<br>
 * 三步：在应用中使用该类<br>
 * 测试一：不写单例，直接new该类对象来使用。<br>
 * 测试二：写成单例模式<br>
 */
public class Copy_1_of_CrashHandler implements UncaughtExceptionHandler {
	private static Copy_1_of_CrashHandler sInstance;

	public static Copy_1_of_CrashHandler getInstance() {
		// 双重检查锁定
		if (sInstance == null) {
			synchronized (Copy_1_of_CrashHandler.class) {
				if (sInstance == null) {
					sInstance = new Copy_1_of_CrashHandler();
				}
			}
		}
		return sInstance;
	}

	private Copy_1_of_CrashHandler() {}

	/**
	 * 回调方法，当程序有异常发生时，会自动执行该方法
	 * 
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread,
	 *      java.lang.Throwable) <br>
	 *      Thread thread 产生异常的线程 <br>
	 *      Throwable ex 产生的异常，且没有try...catch...处理的异常<br>
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e("ASSISTANT", "自定义异常处理:测试一");
	}

}
