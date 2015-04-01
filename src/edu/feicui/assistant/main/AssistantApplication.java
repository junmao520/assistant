package edu.feicui.assistant.main;

import android.app.Application;
import edu.feicui.assistant.util.CrashHandler;

/*
 * 1���̳�Application
 * 2��ע��AssistantApplication
 * */
public class AssistantApplication extends Application {

	/**
	 * ��Ӧ����������ʱ�����onCreate����
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * ��⣺Thread.setDefaultUncaughtExceptionHandler��
		 * ��ͬButton SetOnClickListenerһ�����󶨸��쳣����
		 * ���Զ�ִ�лص�����uncaughtException
		 */
		// ����һ��
		// ��CrashHandler�쳣�����ó�ϵͳĬ�ϵĴ���ʽ.
		// �Ȳ��õ�����ֱ��new�������ԣ�Ȼ��ĳɵ���ģʽ
		// �������쳣�������������У������Կ�����������ʾ��������˼�ʱ�ᵯ���Ի���
		// Thread.setDefaultUncaughtExceptionHandler(new
		// CrashHandler());
		// Thread.setDefaultUncaughtExceptionHandler(CrashHandler.getInstance());
		// ���Զ�������ϵͳ�Ĵ���ʽ�������쳣ʱ���ᵯ�������֮��
		// Copy_2_of_CrashHandler.getInstance().init();
		// �����������쳣��Ϣ������ļ�
		CrashHandler.getInstance().init(this);

	}
}
