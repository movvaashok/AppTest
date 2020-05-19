package com.mak.apptest.controllers;

import com.mak.apptest.Beans.KeyWordMappingBean;
import com.mak.apptest.Beans.TestCaseBean;
import com.mak.apptest.Beans.TestResultBean;
import com.mak.apptest.Beans.TestStepResultBean;
import com.mak.apptest.repository.KeywordMappingsRepository;
import com.mak.apptest.repository.TestCaseDataRepository;
import com.mak.apptest.repository.TestResultsRepository;
import com.mak.apptest.repository.WebObjectIdentifiersRepository;
import com.mak.apptest.services.TestExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestExecutionController {
	Logger log = LoggerFactory.getLogger(TestExecutionController.class);
	List<TestResultBean> testResultBeans = new ArrayList<TestResultBean>();
    @Autowired
    TestCaseDataRepository testCaseDataRepository;
    @Autowired
    KeywordMappingsRepository keywordMappingsRepository;
    @Autowired
    WebObjectIdentifiersRepository objectIdentifiersRepository;
    @Autowired
    TestExecutorService testExecutorService;
    @Autowired
    TestResultsRepository testResultsRepository;


    @GetMapping("/apptest/rest/executeTests/{executionType}")
    public void executeTestCases(@PathVariable("executionType") String executionType) {
        log.trace("Executing testcases for the executionId");
        if (executionType.equalsIgnoreCase("parallel")) {
            log.trace("Executing testcases parallely");
            testCaseDataRepository.findAll().parallelStream().forEach((x) -> testResultBeans.add(executeTest(x)));
        } else if (executionType.equalsIgnoreCase("sequence")) {
            log.trace("Executing testcases sequentially");
            testCaseDataRepository.findAll().stream().forEach((x) -> testResultBeans.add(executeTest(x)));
        }
        testResultsRepository.saveAll(testResultBeans);
        log.trace("Tests Execution Completed!");
    }

    @GetMapping("/apptest/rest/testResults/")
    public List<TestResultBean> testCaseExecutionResults() {
        return testResultBeans;
    }

    private TestResultBean executeTest(TestCaseBean testCaseData) {
        TestResultBean testExecutionResult = new TestResultBean();
        ArrayList<TestStepResultBean> testStepResults = new ArrayList<TestStepResultBean>();
        log.info("Test Execution Started " + testCaseData.getTestCaseName());
        testCaseData.getTestSteps().forEach((testStep) -> {
            log.info("Executing Test Step: " + testStep);
            String keyword = testStep.getKeyword();
            KeyWordMappingBean keyWordBean = keywordMappingsRepository.findByKeyword(keyword).orElseThrow();
            if (keyWordBean.getArgumentType().equalsIgnoreCase("object")) {
                String className = keyWordBean.getImplementationClass();
                String methodName = keyWordBean.getImplementationMethod();
                String valueForKeyword = testStep.getValue();
                testStepResults.add(testExecutorService.executeTestStep(className, methodName, valueForKeyword));
            } else if (keyWordBean.getArgumentType().equalsIgnoreCase("value")) {
                String className = keyWordBean.getImplementationClass();
                String methodName = keyWordBean.getImplementationMethod();
                String valueForKeyword = testStep.getValue();
                testStepResults.add(testExecutorService.executeTestStep(className, methodName, valueForKeyword));
            }
        });
        log.info("Test Execution Completed");
        testExecutionResult.setTestStepResults(testStepResults);
        testExecutionResult.calculateTestResult();
        return testExecutionResult;
    }
	
	/*private void initObject(String ObjectName) {
	
	WebElementAndIdentifierBean x=objectIdentifiersRepository.findByObjectName(ObjectName);
	
	switch (webElementLocatorType) {
	case "id": {
		element = AppMainClass.objWebDriver.findElement(By.id(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "xpath": {
		element = AppMainClass.objWebDriver.findElement(By.xpath(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "css": {
		element = AppMainClass.objWebDriver.findElement(By.cssSelector(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "linktext": {
		element = AppMainClass.objWebDriver.findElement(By.linkText(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "tagname": {
		element = AppMainClass.objWebDriver.findElement(By.tagName(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "classname": {
		element = AppMainClass.objWebDriver.findElement(By.className(webElementLocatorValue));
		retValue = true;
		break;
	}
	case "name": {
		element = AppMainClass.objWebDriver.findElement(By.name(webElementLocatorValue));
		retValue = true;
		break;
	}
	}
	}*/

	public void threadSleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			log.error("Exception in Thread Sleep of " + this.getClass().getName(), e);
		}
	}

}
