package net.atos.sample.dropis;

public class RootAdminRole implements RoleOperation {

	private String roleName;

	public RootAdminRole(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String op() {
		return roleName + "has AAA permission";
	}

}
