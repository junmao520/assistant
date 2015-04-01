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

import java.io.File;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Application;
import android.util.Log;

/**
 * 一步：实现UncaughtExceptionHandler<br>
 * 二步：重写uncaughtException（）方法<br>
 * 三步：在应用中使用该类<br>
 */
public class CrashHandler implements UncaughtExceptionHandler {
	private static CrashHandler sInstance;

	private UncaughtExceptionHandler mDefault;

	public static CrashHandler getInstance() {
		// 双重检查锁定
		if (sInstance == null) {
			synchronized (CrashHandler.class) {
				if (sInstance == null) {
					sInstance = new CrashHandler();
				}
			}
		}
		return sInstance;
	}

	private CrashHandler() {}

	// 传递Application过来，可以获取手机信息？？？？？？？？？？？？
	public void init(Application app) {
		mDefault = Thread.getDefaultUncaughtExceptionHandler();
		// 把CrashHandler异常类设置成系统默认的处理方式
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
		Log.e("ASSISTANT", "自定义异常处理");
		outputException(thread, ex);
		if (mDefault != null) {
			mDefault.uncaughtException(thread, ex);
		}
	}

	/**
	 * 测试三：把异常信息输出成文件，可以传输到服务器上，方便收集,但该APP安装时要在协议中声明，获取用户同意
	 * =================
	 */
	private void outputException(Thread thread, Throwable throwed) {
		PrintWriter pw = null;
		try {
			// Do not hardcode "/sdcard/"; use
			// Environment.getExternalStorageDirectory().getPath()
			// instead
			SimpleDateFormat sdf = new SimpleDateFormat(
					Constants.FILE_NAME_Format, Locale.getDefault());
			String name = sdf.format(new Date()) + ".log";
			File log = new File(Constants.FILE_LOGS, name);
			pw = new PrintWriter(log);
			// 防止传递进来的参数不随意修改？？？？？？？？？？？？？所以用临时变量保留一份
			Throwable throwable = throwed;
			/* 
			  do..while（(throwable = throwable.getCause())!= null）为了获取一次错误信息的所有栈信息
				因为 如果不用循环，只能获取Log日志中的当前错误信息，该错误的由来获取不到
			*/
			do {
				throwable.printStackTrace(pw);
			} while ((throwable = throwable.getCause()) != null);
			pw.flush();
			pw.close();// 一般流的关闭在finally里面，而异常处理中不能那样==============================
		} catch (Throwable ex) {
			// 这里不错任何处理，并且捕获的是Throwable，也就是为了防止错误信息的连锁获取，即递归，自己调用自己
			// 即用try...catch...是为了捕获异常，但不处理异常，因为该处出现的异常如果处理，仍然调用自己会是个递归
		}
	}

}
