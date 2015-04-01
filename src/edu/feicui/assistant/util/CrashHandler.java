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

import java.io.File;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Application;
import android.util.Log;

/**
 * һ����ʵ��UncaughtExceptionHandler<br>
 * ��������дuncaughtException��������<br>
 * ��������Ӧ����ʹ�ø���<br>
 */
public class CrashHandler implements UncaughtExceptionHandler {
	private static CrashHandler sInstance;

	private UncaughtExceptionHandler mDefault;

	public static CrashHandler getInstance() {
		// ˫�ؼ������
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

	// ����Application���������Ի�ȡ�ֻ���Ϣ������������������������
	public void init(Application app) {
		mDefault = Thread.getDefaultUncaughtExceptionHandler();
		// ��CrashHandler�쳣�����ó�ϵͳĬ�ϵĴ���ʽ
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
		Log.e("ASSISTANT", "�Զ����쳣����");
		outputException(thread, ex);
		if (mDefault != null) {
			mDefault.uncaughtException(thread, ex);
		}
	}

	/**
	 * �����������쳣��Ϣ������ļ������Դ��䵽�������ϣ������ռ�,����APP��װʱҪ��Э������������ȡ�û�ͬ��
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
			// ��ֹ���ݽ����Ĳ����������޸ģ���������������������������������ʱ��������һ��
			Throwable throwable = throwed;
			/* 
			  do..while��(throwable = throwable.getCause())!= null��Ϊ�˻�ȡһ�δ�����Ϣ������ջ��Ϣ
				��Ϊ �������ѭ����ֻ�ܻ�ȡLog��־�еĵ�ǰ������Ϣ���ô����������ȡ����
			*/
			do {
				throwable.printStackTrace(pw);
			} while ((throwable = throwable.getCause()) != null);
			pw.flush();
			pw.close();// һ�����Ĺر���finally���棬���쳣�����в�������==============================
		} catch (Throwable ex) {
			// ���ﲻ���κδ������Ҳ������Throwable��Ҳ����Ϊ�˷�ֹ������Ϣ��������ȡ�����ݹ飬�Լ������Լ�
			// ����try...catch...��Ϊ�˲����쳣�����������쳣����Ϊ�ô����ֵ��쳣���������Ȼ�����Լ����Ǹ��ݹ�
		}
	}

}
