package edu.feicui.assistant.util;

import android.util.Log;
import edu.feicui.assistant.BuildConfig;

/**
 * 功能：对Log日志的二次封装。<br>
 * 正式发布版时，不再输出日志信息,只在调试时输出信息<br>
 */
public class LogWrapper {

	private final static boolean DEBUG = true && BuildConfig.DEBUG;

	public static void v(String tag, String msg) {
		if (DEBUG) {
			Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (DEBUG) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (DEBUG) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (DEBUG) {
			Log.e(tag, msg);

		}
	}

	/**
	 * 张琦：架构设计<br>
	 * 日志信息 assert<br>
	 * 19:50 assert:级别最严重，查看Log源代码，对应的是wtf方法。<br>
	 * Log.wtf(tag, msg)查看wtf方法描述：what a Terrible
	 * Failue缩写成wtf<br>
	 * 例如：在使用某个应用时，手机突然自动关闭，或应用自动重启。<br>
	 */
}
