package com.lakala.soa.examples.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lakala.soa.examples.mybatis.model.Article;
import com.lakala.soa.examples.mybatis.model.User;

@Service
public class UserService {

	@Autowired
	SqlSessionTemplate sqlMap;

	public User searchUserById(int id) {
		return (User) sqlMap.selectOne("User.getUserById", id);
	}

	public List<Article> getArticlesByUserId(int id) {
		return (List) sqlMap.selectList("User.getArticlesByUserId", id);
	}

	public void batchInsertUserNoTx() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 2; i++) {
			User user = new User();
			user.setName("someone");
			user.setAge(20);
			user.setAddress("上海");
			users.add(user);
		}
		sqlMap.insert("User.batchInsertUser", users);
		int i = 1 / 0;
		sqlMap.insert("User.batchInsertUser", users);
	}

	@Transactional
	public void batchInsertUserWithTx() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 2; i++) {
			User user = new User();
			user.setName("someone");
			user.setAge(20);
			user.setAddress("上海");
			users.add(user);
		}
		sqlMap.insert("User.batchInsertUser", users);
		int i = 1 / 0;
		sqlMap.insert("User.batchInsertUser", users);
	}

	public int testUpdateNoTx() { // 非事务性

		User user = new User(14, "Tom", 99, "Before exception");
		int affectedCount = sqlMap.update("User.updateUser", user); // 执行成功
		User user2 = new User(15, "Jerry", 99, "After exception");
		int i = 1 / 0; // 抛出运行时异常
		int affectedCount2 = sqlMap.update("User.updateUser", user2); // 未执行
		if (affectedCount == 1 && affectedCount2 == 1) {
			return 1;
		}
		return 0;
	}

	@Transactional()
	public int testUpdateWithTx() { // 事务性

		User user = new User(14, "Tom", 99, "Before exception");
		int affectedCount = sqlMap.update("User.updateUser", user); // 因后面的异常而回滚
		User user2 = new User(15, "Jerry", 99, "After exception");
		int i = 1 / 0; // 抛出运行时异常，事务回滚
		int affectedCount2 = sqlMap.update("User.updateUser", user2); // 未执行
		if (affectedCount == 1 && affectedCount2 == 1) {
			return 1;
		}
		return 0;
	}
}
