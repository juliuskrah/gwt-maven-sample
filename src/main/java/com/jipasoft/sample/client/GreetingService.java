package com.jipasoft.sample.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service with the path {@code /greet}
 */
@RemoteServiceRelativePath("springGwtServices/greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
}
