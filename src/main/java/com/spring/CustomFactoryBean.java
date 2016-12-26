package com.spring;

import org.quartz.Scheduler;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.scheduling.quartz.SchedulerAccessor;

/**
 * public class SchedulerFactoryBean extends SchedulerAccessor implements FactoryBean<Scheduler>, BeanNameAware,
		ApplicationContextAware, InitializingBean, DisposableBean, SmartLifecycle{}
 * @author lakala-shawn
 *
 */
public class CustomFactoryBean {

}
