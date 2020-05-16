package com.mak.apptest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mak.apptest.repository.TestResultsRepository;
import com.mak.apptest.Beans.*;
@RestController
public class TestResultsController {
	@Autowired
	TestResultsRepository testResultsRepository;
	
	@GetMapping("/apptest/rest/testresults?suite={testSuiteName}")
	public Optional<TestResultBean> getTestSuiteResults(@PathVariable("testSuiteName") String testSuiteName) {
		return null;
				//testResultsRepository.findByTestSuite(testSuiteName);
	}
		
	@GetMapping("/apptest/rest/testresults/testcase={testCaseName}")
	public Optional<TestResultBean> getTestCaseResults(@PathVariable("testCaseName") String testCaseName) {
		return testResultsRepository.findByTestName(testCaseName);
	}
	
	@PostMapping("/apptest/rest/testresults?type=suite")
	public void saveTestSuiteResults(@RequestBody TestResultBean testResults) {
		testResultsRepository.save(testResults);
	}
	
	@PostMapping("/apptest/rest/testresults?type=testcase")
	public void saveTestCaseResults(@RequestBody TestResultBean testResults) {
		testResultsRepository.save(testResults);
	}
	
}
