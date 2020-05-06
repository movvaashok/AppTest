package com.mak.AppTest.utilities;

import java.util.HashMap;
import java.util.Map;

public class ActionsAndClassMappings {
	static Map<String, String> actionsAndClass = new HashMap<>();

	static {
		actionsAndClass.put("LaunchWebBrowser", "LaunchWeb");
	}

	public String getActionClassName(String actionName) {
		return actionsAndClass.get(actionName);
	}

}
