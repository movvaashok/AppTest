package com.mak.apptest.Beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
@Document(collection="objectAndIdentifiers")
public class WebElementAndIdentifierBean {
	@Id
	private String objectId;
	private String objectName;
	private String identifier;
	
}
