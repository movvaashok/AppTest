package com.mak.apptest.controllers;

import com.mak.apptest.Beans.KeyWordMappingBean;
import com.mak.apptest.repository.KeywordMappingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KeyWordMappingsController {
	Logger log = LoggerFactory.getLogger(KeyWordMappingsController.class);

	@Autowired
	KeywordMappingsRepository keywordMappingsRepository;

	@GetMapping("/apptest/rest/keywords")
	public ResponseEntity<List<KeyWordMappingBean>> getKeywordMappings() {
		log.trace("Retreving all keywords and class mappings.");
		return ResponseEntity.ok(keywordMappingsRepository.findAll());
	}

	@PostMapping("/apptest/rest/addKeyword")
	public ResponseEntity<KeyWordMappingBean> saveTestCase(@RequestBody KeyWordMappingBean keywordMappingInfo) {
		if (keywordMappingInfo != null) {
			log.trace("Trying to add a keyword :" + keywordMappingInfo.getKeyword());
			KeyWordMappingBean ouput = keywordMappingsRepository.save(keywordMappingInfo);
			return ouput.getKeywordId().isEmpty() ? ResponseEntity.badRequest().build()
					: ResponseEntity.accepted().header("keywordId", ouput.getKeywordId()).build();
		} else {
			log.info("No keyword information found in the request.");
			return ResponseEntity.unprocessableEntity().body(keywordMappingInfo);
		}
	}

	@GetMapping("/apptest/rest/keywords/{keyword}")
	public Optional<KeyWordMappingBean> getKeywordInfo(@PathVariable("keyword") String keyword) {
		log.trace("Retreving details of keyword: " + keyword);
		return keyword == null ? Optional.of(new KeyWordMappingBean())
				: keywordMappingsRepository.findByKeyword(keyword);
	}

	@DeleteMapping("/apptest/rest/removeKeyword/{keywordId}")
	public ResponseEntity<?> deleteKeyword(@PathVariable("keywordId") String keywordId) {
		if (keywordId.isEmpty() || keywordId == null) {
			return ResponseEntity.badRequest().build();
		} else {
			log.trace("Deleting keyword with id: " + keywordId);
			keywordMappingsRepository.findById(keywordId)
					.ifPresent((x) -> keywordMappingsRepository.deleteById(x.getKeywordId()));
			return keywordMappingsRepository.findById(keywordId).isEmpty() ? ResponseEntity.accepted().build()
					: ResponseEntity.badRequest().build();
		}
	}

}