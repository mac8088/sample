package sample;

import java.math.BigDecimal;

public class First {

	public static void main(String args[]) {
		BigDecimal dump = new BigDecimal("-.0");
		System.out.println("-.0 =" + dump);
		System.out.println("0   =" + new BigDecimal("0"));
		System.out.println("0.0 =" + new BigDecimal("0.0"));
		System.out.println("-0  =" + new BigDecimal("-0"));
		System.out.println("-0.0=" + new BigDecimal("-0.0"));
		System.out.println(dump.compareTo(new BigDecimal("-0")) == 0);
		System.out.println("0   =" + new Float("-.0"));
		
	}
}
