package edu.feicui.assistant.util;

import java.io.File;

import android.os.Environment;

public class Constants {
	/* 手机SD卡文件 */
	public static final File FILE_SDCARD = Environment
			.getExternalStorageDirectory();
	/* 手机助手应用根文件 */
	public static final File FILE_APPROOT = new File(FILE_SDCARD, "assistant");
	/* 手机助手应用日志文件 */
	public static final File FILE_LOGS = new File(FILE_APPROOT, "logs");
	/* 手机助手应用文件名时间格式字符 */
	public static final String FILE_NAME_Format = "yyyyMMddHHmmss";
	/* 手机助手应用根文件路径 */
	public static final String PATH_SDCARD = FILE_SDCARD.getAbsolutePath();
	/* 手机助手应用根文件路径 */
	public static final String PATH_APPROOT = FILE_APPROOT.getAbsolutePath();
	/* 手机助手应用日志文件路径 */
	public static final String PATH_LOGS = FILE_LOGS.getAbsolutePath();
	/* 路径 */
	public static final String EXTRA_PATH = "path";
	/* 类型 */
	public static final String EXTRA_SOFT = "type";
	/* 用于批量创建本程序所要用到的目录 */
	static {

		try {
			FILE_APPROOT.mkdirs();
			FILE_LOGS.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
