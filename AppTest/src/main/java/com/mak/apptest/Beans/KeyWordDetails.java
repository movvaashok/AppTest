package com.mak.apptest.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class KeyWordDetails {
	private String webClassName;
	private String mobileClassName;
	private String apiClassName;
}
