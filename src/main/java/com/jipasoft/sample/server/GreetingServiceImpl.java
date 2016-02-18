package com.jipasoft.sample.server;

import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jipasoft.sample.client.GreetingService;
import com.jipasoft.sample.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service. The {@link Service} annotation
 * declares this class as a bean candidate for {@ Dependency Injection}. This eliminates
 * the need to extend {@link RemoteServiceServlet} or contain any other coupling to GWT.
 * Requests to the {@ code /greet} is handled by this bean.
 */
@Service("greet")
public class GreetingServiceImpl implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);

		return "Hello, " + input + " this is Spring";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 *
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
