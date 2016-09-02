package com.lakala.soa.examples.rest.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.lakala.soa.examples.rest.api.UserService;
import com.lakala.soa.examples.rest.vo.User;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月31日 下午6:11:22 <br/>
 * 
 * @author tent
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(UserServiceImpl.class);
	private final AtomicLong idGen = new AtomicLong();

	@Override
	public User getUser(Long id) {
		logger.info("getUser(),id=" + id);
		return new User(id, "username" + id);
	}

	@Override
	public Long registerUser(User user) {
		logger.info("registerUser(),user=" + user);
		// System.out.println("Username is " + user.getName());
		return idGen.incrementAndGet();
	}
}
