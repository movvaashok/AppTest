package com.mak.AppTest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mak.AppTest.Beans.KeyWordMappingBean;

public interface KeywordMappingsRepository extends MongoRepository<KeyWordMappingBean, String> {
	Optional<KeyWordMappingBean> findByKeyword(String keyword);
}
