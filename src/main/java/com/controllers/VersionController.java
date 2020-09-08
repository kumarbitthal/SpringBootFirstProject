package com.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Topic;
import com.services.TopicService;

@CrossOrigin(origins = "*")
@RestController
public class VersionController {

	@Autowired
	private TopicService topicService;

	@GetMapping(value = "/topics", params = "version=2")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopicsV2();
	}

	@RequestMapping(value = "/topics/{id}", headers = "X-API-VERSION=2")
	public Resource<Topic> getTopic(@PathVariable String id) {
		Topic topic = topicService.getTopicV2(Integer.parseInt(id));
		Resource<Topic> resource = new Resource<Topic>(topic);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTopics());
		resource.add(linkTo.withRel("all-topics"));
		return resource;
	}

}
