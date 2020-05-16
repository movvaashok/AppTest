package com.mak.apptest.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mak.apptest.Beans.TestResultBean;

public interface TestResultsRepository extends MongoRepository<TestResultBean, String> {
	Optional<TestResultBean> findByTestName(String testName);
}
