package com.jipasoft.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.jipasoft.sample.client.ui.menu.Menu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JasperGWT implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final String initToken = History.getToken();

		if (initToken.length() == 0) {
			History.newItem("list/1");
		}

		RootPanel.get("menu").add(new Menu());

		History.addValueChangeHandler(new HistoryListener());
		History.fireCurrentHistoryState();
	}
}
