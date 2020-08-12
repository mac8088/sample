package net.atos.sample.lambda;

public class ThreadDemo {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("OK1");
			}
		}).start();

		// JDK8 Lambda 代码简洁 箭头函数
		new Thread(() -> System.out.println("Ok2")).start();
	}
}
