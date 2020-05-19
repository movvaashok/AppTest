package com.mak.apptest.controllers;

import com.mak.apptest.Beans.TestCaseBean;
import com.mak.apptest.repository.TestCaseDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestCaseDataController {
	Logger log = LoggerFactory.getLogger(TestExecutionController.class);

	@Autowired
	TestCaseDataRepository testCaseDataRepository;

	@PostMapping("/apptest/rest/addTestCase")
	public ResponseEntity<TestCaseBean> saveTestCase(@RequestBody TestCaseBean testCaseData) {
		if (testCaseData != null) {
			log.trace("Trying to add a testcase with name :" + testCaseData.getTestCaseName());
			TestCaseBean ouput = testCaseDataRepository.save(testCaseData);
			return ouput.getTestcaseId().isEmpty() ? ResponseEntity.badRequest().build()
					: ResponseEntity.accepted().header("testCaseId", ouput.getTestcaseId()).build();
		} else {
			log.info("No testcase information found in the request.");
			return ResponseEntity.unprocessableEntity().body(testCaseData);
		}
	}

	@GetMapping("/apptest/rest/testCases")
	public ResponseEntity<List<TestCaseBean>> getTestCase() {
		log.trace("Retreving all testcases.");
		return ResponseEntity.ok(testCaseDataRepository.findAll());
	}

	@GetMapping("/apptest/rest/testCases/{testCaseId}")
	public Optional<TestCaseBean> getTestCase(@PathVariable("testCaseId") String testCaseId) {
		log.trace("Retreving testcase with id: " + testCaseId);
		return testCaseId == null ? Optional.of(new TestCaseBean())
				: testCaseDataRepository.findById(testCaseId);
	}

	@DeleteMapping("/apptest/rest/removeTestCase/{testCaseId}")
	public ResponseEntity<?> deleteTestCase(@PathVariable("testCaseId") String testCaseId) {
		if (testCaseId.isEmpty() || testCaseId == null) {
			return ResponseEntity.badRequest().build();
		} else {
			log.trace("Deleting testcase with id: " + testCaseId);
			testCaseDataRepository.findById(testCaseId)
					.ifPresent((x) -> testCaseDataRepository.deleteById(x.getTestcaseId()));
			return testCaseDataRepository.findById(testCaseId).isEmpty() ? ResponseEntity.accepted().build() :
					ResponseEntity.badRequest().build();
		}
	}

}
