package com.mak.apptest.repository;

import com.mak.apptest.Beans.KeyWordMappingBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KeywordMappingsRepository extends MongoRepository<KeyWordMappingBean, String> {
	Optional<KeyWordMappingBean> findByKeyword(String keyword);
}
