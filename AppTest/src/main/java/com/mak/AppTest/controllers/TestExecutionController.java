package com.mak.AppTest.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mak.AppTest.Beans.TestCaseBean;
import com.mak.AppTest.Beans.TestExecutionResultBean;
import com.mak.AppTest.repository.TestCaseDataRepository;

@RestController
public class TestExecutionController {
	Logger log = LoggerFactory.getLogger(TestExecutionController.class);
	List<TestExecutionResultBean> testResultBeans = new ArrayList<TestExecutionResultBean>();
	@Autowired
	TestCaseDataRepository testCaseDataRepository;

	@GetMapping("/apptest/rest/executeTests/{executionType}")
	public void executeTestCases(@PathVariable("executionType") String executionType) {
		log.trace("Executing testcases for the executionId");
		if (executionType.equalsIgnoreCase("parallel")) {
			log.trace("Executing testcases parallely");
			log.info(testCaseDataRepository.findAll().stream().count()+"");
			testCaseDataRepository.findAll().parallelStream().forEach((x) -> executeTest(x));
		} else {
			log.trace("Executing testcases sequentially");
			testCaseDataRepository.findAll().stream().forEach((x) -> executeTest(x));
		}
		log.trace("Tests Execution Completed!");
	}

	@GetMapping("/apptest/rest/testResults/")
	public List<TestExecutionResultBean> testCaseExecutionResults() {
		return testResultBeans;
	}

	private void executeTest(TestCaseBean testCaseData) {
		log.info("Test Execution Started " + testCaseData.getTestCaseName());
		threadSleep(4000);
		log.info("Test Execution Completed");
		testResultBeans.add(
				new TestExecutionResultBean(testCaseData.getTestCaseName(), testCaseData.getTestCaseName(), "Passed"));
	}

	public void threadSleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			log.error("Exception in Thread Sleep of " + this.getClass().getName(), e);
		}
	}
}
