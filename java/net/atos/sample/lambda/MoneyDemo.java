package net.atos.sample.lambda;

import java.text.DecimalFormat;

interface IMoneyFormat {
	String format(int i);
}

class MyMoney {

	private final int money;

	public MyMoney(int money) {
		this.money = money;
	}

	public void printMoney(IMoneyFormat moneyFormat) {
		System.out.println("我的存款： " + moneyFormat.format(this.money));
	}

}

public class MoneyDemo {

	public static void main(String args[]) {
		MyMoney me = new MyMoney(999999);
		me.printMoney((i) -> new DecimalFormat("#,###").format(i));
	}

}
