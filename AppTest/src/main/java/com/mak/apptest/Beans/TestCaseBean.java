package com.mak.apptest.Beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TestCasesData")
public class TestCaseBean {
	@Id
	private String testcaseId;
	private String testCaseName;
	private String testCaseDescription;
	private List<TestStepsBean> testSteps;
}

