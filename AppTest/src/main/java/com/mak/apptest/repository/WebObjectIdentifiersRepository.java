package com.mak.apptest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mak.apptest.Beans.WebElementAndIdentifierBean;


public interface WebObjectIdentifiersRepository extends MongoRepository<WebElementAndIdentifierBean, String>  {
	WebElementAndIdentifierBean findByObjectName(String objectName);
}
