package com.mak.apptest.Beans;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection= "TestResults")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TestResultBean {
	@Id
	private String testCaseId;
	private String testName;
	private String testResult;
	private List<TestStepResultBean> testStepResults;
	
	public void calculateTestResult() {
		this.testStepResults.forEach((stepResultData)->{
			if(stepResultData.getResult().equalsIgnoreCase("failed"))
				this.testResult="Failed";
			});
	}
}
