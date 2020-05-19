package com.mak.apptest.repository;

import com.mak.apptest.Beans.TestResultBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TestResultsRepository extends MongoRepository<TestResultBean, String> {
	Optional<TestResultBean> findByTestName(String testName);
}
