package com.jipasoft.sample.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jipasoft.sample.client.service.UserService;
import com.jipasoft.sample.shared.dao.UserDao;
import com.jipasoft.sample.shared.model.User;

/**
 * The server side implementation of the RPC service. The {@link Service}
 * annotation declares this class as a bean candidate for {@ Dependency
 * Injection}. This eliminates the need to extend {@link RemoteServiceServlet}
 * or contain any other coupling to GWT. Requests to the {@ code /userService}
 * is handled by this bean.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	UserDao userDao;

	@Autowired
	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findById(final Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void saveOrUpdate(final User user) {

		if (findById(user.getId()) == null) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}

	}

	@Override
	public void delete(final int id) {
		userDao.delete(id);
	}

}