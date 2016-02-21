package com.jipasoft.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.History;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JasperGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	// @formatter:off
	private static final String SERVER_ERROR = "An error occurred while " 
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	// @formatter:on

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		String initToken = History.getToken();

		if (initToken.length() == 0)
			History.newItem(URL.encode("list"));

		History.addValueChangeHandler(new HistoryListener());
		History.fireCurrentHistoryState();
	}
}
