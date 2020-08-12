package net.atos.sample.lambda;

public class ThreadDemo2 {

	public static void main(String[] args) {
		Object target = new Runnable() {

			@Override
			public void run() {
				System.out.println("ok");
			}
		};
		new Thread((Runnable) target).start();

		// jdk8 lambda
		Object target2 = (Runnable) () -> System.out.println("ok");
		Runnable target3 = () -> System.out.println("ok"); // @FunctionalInterface
		System.out.println(target2 == target3); // false

		// lambda表达式就是实现了一个实现指定接口的对象实例
		new Thread((Runnable) target2).start();
	}

}
