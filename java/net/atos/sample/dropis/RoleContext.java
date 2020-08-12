package net.atos.sample.dropis;

public class RoleContext {

	// 可以更改的策略，传入不同的策略对象，业务即相应变化
	private RoleOperation operation;

	public RoleContext(RoleOperation operation) {
		this.operation = operation;
	}

	public String execute() {
		return operation.op();
	}

}
