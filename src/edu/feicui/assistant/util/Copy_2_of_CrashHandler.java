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
 * 一步：Thread.getDefaultUncaughtExceptionHandler()<br>
 * 获取系统原来的UncaughtExceptionHandler对象<br>
 * 二步：Thread.setDefaultUncaughtExceptionHandler(this)<br>
 * 用自定义的替换原来的UncaughtExceptionHandler对象<br>
 * 三步：mDefault.uncaughtException(thread, ex);<br>
 * 调用系统的处理方式<br>
 */
public class Copy_2_of_CrashHandler implements UncaughtExceptionHandler {
	private static Copy_2_of_CrashHandler sInstance;

	/** UncaughtExceptionHandler用来处理没有被try..catch。。处理的异常 */
	private UncaughtExceptionHandler mDefault;

	public static Copy_2_of_CrashHandler getInstance() {
		// 双重检查锁定
		if (sInstance == null) {
			synchronized (Copy_2_of_CrashHandler.class) {
				if (sInstance == null) {
					sInstance = new Copy_2_of_CrashHandler();
				}
			}
		}
		return sInstance;
	}

	private Copy_2_of_CrashHandler() {}

	public void init() {
		mDefault = Thread.getDefaultUncaughtExceptionHandler();
		// 把CrashHandler异常类设置成系统默认的处理方式,这样就把系统的给替换掉了
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

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
		Log.e("ASSISTANT", "自定义异常处理：测试二");
		if (mDefault != null) {
			// 测试二：调用系统的处理方式，当有异常时，会弹出警告框之类
			mDefault.uncaughtException(thread, ex);
		}
	}

}
