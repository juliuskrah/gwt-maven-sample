package com.jipasoft.sample.client.ui.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.jipasoft.sample.client.Content;
import com.jipasoft.sample.client.service.UserService;
import com.jipasoft.sample.client.service.UserServiceAsync;
import com.jipasoft.sample.shared.model.User;

public class List extends Content {

	private static ListUiBinder uiBinder = GWT.create(ListUiBinder.class);
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	// @formatter:off
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	// @formatter:on
	private final UserServiceAsync userService = GWT.create(UserService.class);

	@UiField
	TableElement table;

	interface ListUiBinder extends UiBinder<Widget, List> {
	}

	public List() {
		initWidget(uiBinder.createAndBindUi(this));
		userService.findAll(new AsyncCallback<java.util.List<User>>() {

			@Override
			public void onSuccess(java.util.List<User> result) {
				createTable(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(SERVER_ERROR);
			}
		});

	}

	private void createTable(java.util.List<User> result) {

		if (result == null || result.size() == 0) {
			final TableRowElement row = table.insertRow(1);

			TableCellElement cell = row.insertCell(0);
			cell.setColSpan(5);
			cell.setInnerHTML("No data found");

			return;
		}

		TableRowElement row = null;
		int i = 1;
		for (User user : result) {

			row = table.insertRow(i);

			row.insertCell(0).setInnerHTML(String.valueOf(user.getId()));
			row.insertCell(1).setInnerHTML(user.getName());
			row.insertCell(2).setInnerHTML(user.getEmail());
			row.insertCell(3).setInnerHTML(user.getFramework().toString());
			row.insertCell(4).setInnerHTML(button(""));

			i++;
		}

	}

	private String button(String id) {
		//@formatter:off
		String buttons = "<button class=\"btn btn-info\">Query</button> " 
					   + "<button class=\"btn btn-primary\">Update</button> "
					   + "<button class=\"btn btn-danger\">Delete</button>";
		//@formatter:on

		return buttons;
	}

	@Override
	public String getHtmlTitle() {
		return "List || GWT Maven Application";
	}

}
