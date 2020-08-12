package net.atos.sample.dropis;

// 有枚举为啥不用, 我们将不同角色的情况全部交由枚举类来做, 定义一个不同角色有不同权限的枚举类
public enum RoleEnum implements RoleOperation {

	// 系统管理员有A权限
	ROLE_ROOT_ADMIN {
		@Override
		public String op() {
			return "ROLE_ROOT_ADMIN: " + "has AAA permission";
		}
	},

	// 订单管理员有B权限
	ROLE_ORDER_ADMIN {
		@Override
		public String op() {
			return "ROLE_ORDER_ADMIN: " + "has BBB permission";
		}
	},

	// 普通用户有C权限
	ROLE_NORMAL {
		@Override
		public String op() {
			return "ROLE_NORMAL: " + "has CCC permission";
		}
	}
}
