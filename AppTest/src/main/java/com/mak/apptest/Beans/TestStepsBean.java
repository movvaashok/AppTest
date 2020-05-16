package com.mak.apptest.Beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestStepsBean{
	private String keyword;
	private String objectName;
	private String value;
	@Override
	public String toString() {
		return keyword+":"+objectName+":"+value;
	}

}