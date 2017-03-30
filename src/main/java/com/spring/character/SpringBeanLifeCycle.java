package com.spring.character;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SpringBeanLifeCycle implements InitializingBean, DisposableBean {

	/**
	 * from DisposableBean
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * from InitializingBean
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// spring 中不需要通过构造函数里来初始化，最好通过afterPropertiesSet方法里调用所有以其他属性都准备好。

	}

}
