package com.mak.apptest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mak.apptest.Beans.TestCaseBean;

public interface TestCaseDataRepository extends MongoRepository<TestCaseBean, String> {
}
