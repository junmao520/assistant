package edu.feicui.assistant.util;

import java.io.File;

import android.os.Environment;

public class Constants {
	/* �ֻ�SD���ļ� */
	public static final File FILE_SDCARD = Environment
			.getExternalStorageDirectory();
	/* �ֻ�����Ӧ�ø��ļ� */
	public static final File FILE_APPROOT = new File(FILE_SDCARD, "assistant");
	/* �ֻ�����Ӧ����־�ļ� */
	public static final File FILE_LOGS = new File(FILE_APPROOT, "logs");
	/* �ֻ�����Ӧ���ļ���ʱ���ʽ�ַ� */
	public static final String FILE_NAME_Format = "yyyyMMddHHmmss";
	/* �ֻ�����Ӧ�ø��ļ�·�� */
	public static final String PATH_SDCARD = FILE_SDCARD.getAbsolutePath();
	/* �ֻ�����Ӧ�ø��ļ�·�� */
	public static final String PATH_APPROOT = FILE_APPROOT.getAbsolutePath();
	/* �ֻ�����Ӧ����־�ļ�·�� */
	public static final String PATH_LOGS = FILE_LOGS.getAbsolutePath();
	/* ·�� */
	public static final String EXTRA_PATH = "path";
	/* ���� */
	public static final String EXTRA_SOFT = "type";
	/* ��������������������Ҫ�õ���Ŀ¼ */
	static {

		try {
			FILE_APPROOT.mkdirs();
			FILE_LOGS.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
