package net.atos.sample.dropis;

import java.util.HashMap;
import java.util.Map;

// 不同分支做不同的事情，很明显就提供了使用工厂模式的契机，我们只需要将不同情况单独定义好，然后去工厂类里面聚合即可。
public class RoleFactory {

	static Map<String, RoleOperation> roleOperationMap = new HashMap<>();

	// 在静态块中先把初始化工作全部做完
	static {
		roleOperationMap.put("ROLE_ROOT_ADMIN", new RootAdminRole("ROLE_ROOT_ADMIN"));
		roleOperationMap.put("ROLE_ORDER_ADMIN", new OrderAdminRole("ROLE_ORDER_ADMIN"));
		roleOperationMap.put("ROLE_NORMAL", new NormalRole("ROLE_NORMAL"));
	}

	// 写一个工厂类 RoleFactory对上面不同角色进行聚合
	public static RoleOperation getOp(String roleName) {
		return roleOperationMap.get(roleName);
	}
}
