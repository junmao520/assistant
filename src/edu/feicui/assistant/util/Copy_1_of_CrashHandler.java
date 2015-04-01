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
 * һ����ʵ��UncaughtExceptionHandler����������û�б�try..catch����������쳣��<br>
 * ��������дuncaughtException��������<br>
 * ��������Ӧ����ʹ�ø���<br>
 * ����һ����д������ֱ��new���������ʹ�á�<br>
 * ���Զ���д�ɵ���ģʽ<br>
 */
public class Copy_1_of_CrashHandler implements UncaughtExceptionHandler {
	private static Copy_1_of_CrashHandler sInstance;

	public static Copy_1_of_CrashHandler getInstance() {
		// ˫�ؼ������
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
	 * �ص����������������쳣����ʱ�����Զ�ִ�и÷���
	 * 
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread,
	 *      java.lang.Throwable) <br>
	 *      Thread thread �����쳣���߳� <br>
	 *      Throwable ex �������쳣����û��try...catch...������쳣<br>
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e("ASSISTANT", "�Զ����쳣����:����һ");
	}

}
