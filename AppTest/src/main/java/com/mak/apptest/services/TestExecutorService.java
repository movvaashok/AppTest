package com.mak.apptest.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mak.apptest.Beans.TestStepResultBean;
import com.mak.apptest.controllers.TestExecutionController;

@Service
public class TestExecutorService {
	Logger log = LoggerFactory.getLogger(TestExecutionController.class);
	@Autowired
	private ApplicationContext context;

	public TestStepResultBean executeTestStep(String keyword, String methodName, String parameter) {
		TestStepResultBean testStepResult = new TestStepResultBean();
		log.info("Executing " + keyword + " with keyword action " + methodName);
		try {
			Object bean = context.getBean(keyword);
			Method method = bean.getClass().getMethod(methodName, String.class, String.class, String.class);
			if ((boolean) method.invoke(bean, keyword, methodName, parameter)) {
				testStepResult.setResult("Passed");
				return testStepResult;
			} else {
				testStepResult.setResult("Failed");
			}
		} catch (BeansException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
			testStepResult.setResult("Failed");
		} catch (IllegalAccessException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
			testStepResult.setResult("Failed");
		} catch (IllegalArgumentException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
			testStepResult.setResult("Failed");
		} catch (InvocationTargetException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
			testStepResult.setResult("Failed");
		} catch (NoSuchMethodException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
			testStepResult.setResult("Failed");
		} catch (SecurityException e) {
			testStepResult.setFailureException(e);
			testStepResult.setFailureMessage(e.getMessage());
		}
		return testStepResult;
	}
}
