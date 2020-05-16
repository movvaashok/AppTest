package com.mak.apptest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mak.apptest.Beans.*;

public interface KeywordMappingsRepository extends MongoRepository<KeyWordMappingBean, String> {
	Optional<KeyWordMappingBean> findByKeyword(String keyword);
}
