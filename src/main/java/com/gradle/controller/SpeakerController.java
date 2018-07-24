package com.gradle.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @author liulei
 * @date 2018年7月24日 上午10:49:54
 */
@RestController
public class SpeakerController {
	private static Speaker speakers[] = {
			new Speaker(1, 39, "Larson Richard", new String[] { "JavaScript", "AngularJS", "Yeoman" }, true),
			new Speaker(2, 29, "Ester Clements", new String[] { "REST", "Ruby on Rails", "APIs" }, true),
			new Speaker(3, 45, "Christensen Fisher", new String[] { "Java", "Spring", "Maven", "REST" }, false) };

	@RequestMapping(value = "/speakers", method = RequestMethod.GET)
	public List<Speaker> getAllSpeakers() {
		return Arrays.asList(speakers);
	}

	@RequestMapping(value = "/speakers/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSpeakerById(@PathVariable long id) {
		int tempId = ((new Long(id)).intValue() - 1);
		if (tempId >= 0 && tempId < speakers.length) {
			return new ResponseEntity<Speaker>(speakers[tempId], HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
