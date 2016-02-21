package com.jipasoft.sample.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class ContentContainer {
	private static ContentContainer instance;

	public static ContentContainer getInstance() {
		instance = new ContentContainer();

		return instance;
	}

	public void setContent(final Content content) {
		RootPanel.get("body").clear();
		Window.setTitle(content.getHtmlTitle());
		RootPanel.get("body").add(content);
	}

}
