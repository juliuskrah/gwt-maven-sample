package com.jipasoft.sample.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.jipasoft.sample.client.ui.users.List;
import com.jipasoft.sample.client.ui.users.Show;
import com.jipasoft.sample.client.ui.users.UserForm;

public class HistoryListener implements ValueChangeHandler<String> {

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {
		final String url = event.getValue();
		System.out.println(url);

		if (url.startsWith("show")) {
			ContentContainer.getInstance().setContent(new Show());
		} else if (url.startsWith("list")) {
			ContentContainer.getInstance().setContent(new List());
		} else if (url.startsWith("userForm")) {
			ContentContainer.getInstance().setContent(new UserForm());
		} else if (url.startsWith("updateUser")) {
			ContentContainer.getInstance().setContent(new UserForm());
		}

	}

}
