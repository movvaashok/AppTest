package com.mak.apptest.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
@Document(collection = "objectAndIdentifiers")
public class WebElementAndIdentifierBean {
	@Id
	private String objectId;
	private String objectName;
	private String identifier;

}
