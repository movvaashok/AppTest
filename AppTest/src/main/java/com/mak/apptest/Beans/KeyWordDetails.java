package com.mak.apptest.Beans;

import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
public class KeyWordDetails {
	private String webClassName;
	private String mobileClassName;
	private String apiClassName;
}
