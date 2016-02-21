package com.jipasoft.sample.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jipasoft.sample.shared.model.User;

/**
 * The client side stub for the RPC service with the path {@code /user}
 */
@RemoteServiceRelativePath("springGwtServices/userService")
public interface UserService extends RemoteService {

	User findById(Integer id);

	List<User> findAll();

	void saveOrUpdate(User user);

	void delete(int id);

}