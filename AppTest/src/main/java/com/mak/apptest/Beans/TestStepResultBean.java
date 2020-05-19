package com.mak.apptest.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestStepResultBean {
	private String result;
	private String failureMessage;
	private Exception failureException;
}
