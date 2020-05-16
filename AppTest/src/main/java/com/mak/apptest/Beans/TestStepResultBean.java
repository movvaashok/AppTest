package com.mak.apptest.Beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestStepResultBean {
	private String result;
	private String failureMessage;
	private Exception failureException;
}
