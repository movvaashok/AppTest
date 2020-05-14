package com.mak.AppTest.Beans;

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
	private String elementIdentifier;
	private String value;
	@Override
	public String toString() {
		return keyword+":"+elementIdentifier+":"+value;
	}

}