package com.jipasoft.sample.client.ui.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.jipasoft.sample.client.Content;

public class List extends Content implements HasText {

	private static ListUiBinder uiBinder = GWT.create(ListUiBinder.class);

	interface ListUiBinder extends UiBinder<Widget, List> {
	}

	public List() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public List(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem(URL.encode("show"));
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public String getHtmlTitle() {
		return "List || GWT Maven Application";
	}

}
