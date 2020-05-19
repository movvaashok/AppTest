package com.mak.apptest.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Document(collection = "keywordMapping")
public class KeyWordMappingBean {
	@Id
	private String keywordId;
	@Indexed
	private String keyword;
	private String argumentType;
	private String implementationClass;
	private String implementationMethod;
	private KeyWordDetails details;
}
