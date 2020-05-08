package com.mak.AppTest.Beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class TestExecutionResultBean {
	private String testCaseId;
	private String testName;
	private String testResult;

	public TestExecutionResultBean(String testCaseId,String testName, String testResult) {
		this.testCaseId=testCaseId;
		this.testName = testName;
		this.testResult = testResult;
	}

}
