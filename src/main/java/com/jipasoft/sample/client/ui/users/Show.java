/**
 *
 */
package com.jipasoft.sample.client.ui.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.jipasoft.sample.client.Content;

/**
 * @author Julius Krah
 *
 */
public class Show extends Content {

	private static ShowUiBinder uiBinder = GWT.create(ShowUiBinder.class);

	interface ShowUiBinder extends UiBinder<Widget, Show> {
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
	public Show() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getHtmlTitle() {
		return "Show || GWT Maven Application";
	}

}
