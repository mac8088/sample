package net.atos.sample.dropis;

public class JudgeRole {

	// 我们需要根据不同用户的角色来判断其有哪些行为，这时候SAO代码出现了
	public String judge(String roleName) {
		String result = "";
		if (roleName.equals("ROLE_ROOT_ADMIN")) {
			// 系统管理员有A权限
			result = "ROLE_ROOT_ADMIN: " + "has AAA permission";
		} else if (roleName.equals("ROLE_ORDER_ADMIN")) {
			// 订单管理员有B权限
			result = "ROLE_ORDER_ADMIN: " + "has BBB permission";
		} else if (roleName.equals("ROLE_NORMAL")) {
			// 普通用户有C权限
			result = "ROLE_NORMAL: " + "has CCC permission";
		} else {
			result = "XXX";
		}
		return result;
	}

	// 一行代码就行了， if/else也灰飞烟灭了
	public String enumJudge(String roleName) {
		// 一行代码搞定！之前的if/else没了！
		return RoleEnum.valueOf(roleName).op();
	}

	// 这样的话以后想扩展条件也很容易，只需要增加新代码，而不需要动以前的业务代码，非常符合“开闭原则”。
	public String factJudge(String roleName) {
		// 借助上面这个工厂，业务代码调用也只需一行代码， if/else同样被消除了
		return RoleFactory.getOp(roleName).op();
	}

	// 传入的参数 operation就是表示不同的“策略”
	public String celeJudge(RoleOperation roleOperation) {
		RoleContext rc = new RoleContext(roleOperation);
		// 我们在业务代码里传入不同的角色，即可得到不同的操作结果
		return rc.execute();

	}

}
