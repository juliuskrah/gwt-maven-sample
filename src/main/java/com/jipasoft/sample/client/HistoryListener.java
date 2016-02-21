package com.jipasoft.sample.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.URL;
import com.jipasoft.sample.client.ui.users.List;
import com.jipasoft.sample.client.ui.users.Show;

public class HistoryListener implements ValueChangeHandler<String> {

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String url = URL.decode(event.getValue());
		System.out.println(url);

		if (url.equals("show"))
			ContentContainer.getInstance().setContent(new Show("Julius"));
		else if (url.equals("list"))
			ContentContainer.getInstance().setContent(new List("James"));

	}

}
