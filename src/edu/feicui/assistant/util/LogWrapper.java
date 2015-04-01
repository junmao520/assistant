package edu.feicui.assistant.util;

import android.util.Log;
import edu.feicui.assistant.BuildConfig;

/**
 * ���ܣ���Log��־�Ķ��η�װ��<br>
 * ��ʽ������ʱ�����������־��Ϣ,ֻ�ڵ���ʱ�����Ϣ<br>
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
	 * �������ܹ����<br>
	 * ��־��Ϣ assert<br>
	 * 19:50 assert:���������أ��鿴LogԴ���룬��Ӧ����wtf������<br>
	 * Log.wtf(tag, msg)�鿴wtf����������what a Terrible
	 * Failue��д��wtf<br>
	 * ���磺��ʹ��ĳ��Ӧ��ʱ���ֻ�ͻȻ�Զ��رգ���Ӧ���Զ�������<br>
	 */
}
