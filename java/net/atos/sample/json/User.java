package net.atos.sample.json;

import java.util.Date;

public class User {

	int id;
	String name;
	String sex;
	Date birthday;

	public User() {
	}

	public User(int id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public User(int id, String name, String sex, Date birthday) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
