package com.mak.apptest.repository;

import com.mak.apptest.Beans.WebElementAndIdentifierBean;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface WebObjectIdentifiersRepository extends MongoRepository<WebElementAndIdentifierBean, String> {
    WebElementAndIdentifierBean findByObjectName(String objectName);
}
