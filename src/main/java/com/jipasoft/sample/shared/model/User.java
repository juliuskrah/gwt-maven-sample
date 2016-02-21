package com.jipasoft.sample.shared.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// form:hidden - hidden value
	Integer id;

	// form:input - textbox
	String name;

	// form:input - textbox
	String email;

	// form:textarea - textarea
	String address;

	// form:input - password
	String password;

	// form:input - password
	String confirmPassword;

	// form:checkbox - single checkbox
	boolean newsletter;

	// form:checkboxes - multiple checkboxes
	List<String> framework;

	// form:radiobutton - radio button
	String sex;

	// form:radiobuttons - radio button
	Integer number;

	// form:select - form:option - dropdown - single select
	String country;

	// form:select - multiple=true - dropdown - multiple select
	List<String> skill;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(final boolean newsletter) {
		this.newsletter = newsletter;
	}

	public List<String> getFramework() {
		return framework;
	}

	public void setFramework(final List<String> framework) {
		this.framework = framework;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(final String sex) {
		this.sex = sex;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(final List<String> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", newsletter=" + newsletter + ", framework=" + framework + ", sex=" + sex
				+ ", number=" + number + ", country=" + country + ", skill=" + skill + "]" + isNew();
	}

}
