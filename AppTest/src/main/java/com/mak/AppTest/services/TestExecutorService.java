package com.mak.AppTest.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mak.AppTest.controllers.TestExecutionController;

@Service
public class TestExecutorService {
	Logger log = LoggerFactory.getLogger(TestExecutionController.class);
	@Autowired
	private ApplicationContext context;

	public boolean executeMethod(String keyword, String methodName, String parameter) {
		log.info("Executing " + keyword + " with keyword action " + methodName);
		try {
			Object bean = context.getBean(keyword);
			Method method = bean.getClass().getMethod(methodName, String.class, String.class, String.class);
			return (boolean) method.invoke(bean, keyword, methodName, parameter);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}
}
