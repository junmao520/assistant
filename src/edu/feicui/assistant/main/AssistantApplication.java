package edu.feicui.assistant.main;

import android.app.Application;
import edu.feicui.assistant.util.CrashHandler;

/*
 * 1、继承Application
 * 2、注册AssistantApplication
 * */
public class AssistantApplication extends Application {

	/**
	 * 该应用在启动的时候调用onCreate（）
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * 理解：Thread.setDefaultUncaughtExceptionHandler。
		 * 雷同Button SetOnClickListener一样，绑定该异常处理，
		 * 会自动执行回调方法uncaughtException
		 */
		// 测试一：
		// 把CrashHandler异常类设置成系统默认的处理方式.
		// 先不用单例，直接new出来测试，然后改成单例模式
		// 程序有异常，不能正常运行，但可以看到界面能显示，点击回退键时会弹出对话框
		// Thread.setDefaultUncaughtExceptionHandler(new
		// CrashHandler());
		// Thread.setDefaultUncaughtExceptionHandler(CrashHandler.getInstance());
		// 测试二：调用系统的处理方式，当有异常时，会弹出警告框之类
		// Copy_2_of_CrashHandler.getInstance().init();
		// 测试三：把异常信息输出成文件
		CrashHandler.getInstance().init(this);

	}
}
