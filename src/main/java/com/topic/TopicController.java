package com.topic;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/")
	public String getHomePage() {
		return topicService.getHomePage();
	}
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(Integer.parseInt(id));
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public ResponseEntity<Object> deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/topics")
	public ResponseEntity<Object> addTopic(@Validated @RequestBody Topic topic) {
		topicService.addTopic(topic);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(topic.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void addTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(Integer.parseInt(id), topic);
	}
}