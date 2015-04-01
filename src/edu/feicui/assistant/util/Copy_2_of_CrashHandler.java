/*
 * @(#): CrashHandler.java
 * @project: �ֻ�����
 * @version: 1.0
 * @copyright: Copyright (C) 2013-2014 
 * @description: 
 * 
 * @modify:
 * ---- No.1 Modified By android At 2014-5-9 ����3:58:35 Based On v0 ----
 *      Create file
 */

package edu.feicui.assistant.util;

import java.lang.Thread.UncaughtExceptionHandler;

import android.util.Log;

/**
 * һ����Thread.getDefaultUncaughtExceptionHandler()<br>
 * ��ȡϵͳԭ����UncaughtExceptionHandler����<br>
 * ������Thread.setDefaultUncaughtExceptionHandler(this)<br>
 * ���Զ�����滻ԭ����UncaughtExceptionHandler����<br>
 * ������mDefault.uncaughtException(thread, ex);<br>
 * ����ϵͳ�Ĵ���ʽ<br>
 */
public class Copy_2_of_CrashHandler implements UncaughtExceptionHandler {
	private static Copy_2_of_CrashHandler sInstance;

	/** UncaughtExceptionHandler��������û�б�try..catch����������쳣 */
	private UncaughtExceptionHandler mDefault;

	public static Copy_2_of_CrashHandler getInstance() {
		// ˫�ؼ������
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
		// ��CrashHandler�쳣�����ó�ϵͳĬ�ϵĴ���ʽ,�����Ͱ�ϵͳ�ĸ��滻����
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * �ص����������������쳣����ʱ�����Զ�ִ�и÷���
	 * 
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread,
	 *      java.lang.Throwable) <br>
	 *      Thread thread �����쳣���߳� <br>
	 *      Throwable ex �������쳣����û��try...catch...������쳣<br>
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e("ASSISTANT", "�Զ����쳣�������Զ�");
		if (mDefault != null) {
			// ���Զ�������ϵͳ�Ĵ���ʽ�������쳣ʱ���ᵯ�������֮��
			mDefault.uncaughtException(thread, ex);
		}
	}

}
