/**
 * 
 */
package com.jipasoft.sample.client.ui.users;

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.jipasoft.sample.client.Content;
import com.jipasoft.sample.shared.FieldVerifier;

/**
 * @author Julius Krah
 *
 */
public class UserForm extends Content {

	private static UserFormUiBinder uiBinder = GWT.create(UserFormUiBinder.class);
	@UiField
	SpanElement span;
	@UiField
	DivElement nameDiv;
	@UiField
	DivElement emailDiv;
	@UiField
	DivElement passwordDiv;
	@UiField
	DivElement confirmPasswordDiv;
	@UiField
	DivElement addressDiv;
	@UiField
	DivElement frameworkDiv;
	@UiField
	DivElement countryDiv;
	@UiField
	DivElement skillDiv;
	@UiField
	TextBox name;
	@UiField
	TextBox email;
	@UiField
	PasswordTextBox password;
	@UiField
	PasswordTextBox confirmPassword;
	@UiField
	TextArea address;
	@UiField
	CheckBox newsletter;
	@UiField
	CheckBox framework1;
	@UiField
	CheckBox framework2;
	@UiField
	CheckBox framework3;
	@UiField
	CheckBox framework4;
	@UiField
	CheckBox framework5;
	@UiField
	CheckBox framework6;
	@UiField
	RadioButton sex1;
	@UiField
	RadioButton sex2;
	@UiField
	RadioButton number1;
	@UiField
	RadioButton number2;
	@UiField
	RadioButton number3;
	@UiField
	RadioButton number4;
	@UiField
	RadioButton number5;
	@UiField
	ValueListBox<String> country;
	@UiField
	ListBox skill;
	@UiField
	Label nameLabel;
	@UiField
	Label emailLabel;
	@UiField
	Label passwordLabel;
	@UiField
	Label confirmPasswordLabel;
	@UiField
	Label addressLabel;
	@UiField
	Label frameworkLabel;
	@UiField
	Label countryLabel;
	@UiField
	Label skillLabel;
	@UiField
	Button submit;

	interface UserFormUiBinder extends UiBinder<Widget, UserForm> {
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
	 * "urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */
	public UserForm() {
		initWidget(uiBinder.createAndBindUi(this));
		initWidgets();

		String url = History.getToken();

		if (url.startsWith("userForm")) {
			submit.setText("Add");
			span.setInnerText("Add User");
		} else {
			submit.setText("Update");
			span.setInnerText("Update User");
		}
	}

	@Override
	public String getHtmlTitle() {
		return "UserForm || GWT Maven Application";
	}

	@UiHandler("submit")
	public void clickSubmit(ClickEvent event) {
		if (submit.getText().equals("Add") && !addUserValidation()) {
			History.newItem("show");
		}
	}

	@UiHandler("name")
	public void nameOnChange(ValueChangeEvent<String> event) {
		addUserValidation();
	}

	private boolean addUserValidation() {
		boolean status = false;

		if (!FieldVerifier.isValidName(name.getValue())) {
			nameDiv.addClassName("has-error");
			nameLabel.setVisible(true);
		} else {
			nameDiv.removeClassName("has-error");
			nameLabel.setVisible(false);
		}
		return status;
	}

	private void initWidgets() {
		java.util.List<String> list = Arrays.asList("United States", "China", "Singapore", "Malaysia");

		name.setValue("julius123");
		email.setValue("test@gmail.com");
		address.setValue("abc 88");
		country.setAcceptableValues(list);

		skill.addItem("Hibernate", "Hibernate");
		skill.addItem("Spring", "Struts");
		skill.addItem("Struts", "Struts");
		skill.addItem("Groovy", "Groovy");
		skill.addItem("Grails", "Grails");
		skill.setItemSelected(2, true);
	}

}
