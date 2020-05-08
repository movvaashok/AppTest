package com.mak.AppTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mak.AppTest.Beans.TestCaseBean;

public interface TestCaseDataRepository extends MongoRepository<TestCaseBean, String> {
}
