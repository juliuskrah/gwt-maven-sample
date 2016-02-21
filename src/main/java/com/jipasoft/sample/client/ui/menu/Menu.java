/**
 *
 */
package com.jipasoft.sample.client.ui.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Julius Krah
 *
 */
public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	@UiField
	Anchor home;
	@UiField
	Anchor user;

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
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
	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("home")
	public void clicHome(final ClickEvent event) {
		History.newItem("list");
	}

	@UiHandler("user")
	public void clickUser(final ClickEvent event) {
		History.newItem("userForm");
	}
}
