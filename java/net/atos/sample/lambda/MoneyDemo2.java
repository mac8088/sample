package net.atos.sample.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

class MyMoney2 {

	private final int money;

	public MyMoney2(int money) {
		this.money = money;
	}

	// 使用函数接口的好处： 就是不用定义那么的接口，也支持链式调用
	public void printMoney(Function<Integer, String> moneyFormat) {
		System.out.println("我的存款： " + moneyFormat.apply(this.money));
	}
}

public class MoneyDemo2 {

	public static void main(String args[]) {
		MyMoney2 me = new MyMoney2(999999);
		Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
		// 函数接口的链式调用， 可以更加灵活的操作
		me.printMoney(moneyFormat.andThen(s -> "人民币 " + s));

	}

}
