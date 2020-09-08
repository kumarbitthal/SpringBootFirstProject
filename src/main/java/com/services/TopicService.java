package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.number.IsCloseTo;
import org.springframework.stereotype.Service;

import com.beans.Topic;
import com.exceptions.TopicNotFoundException;

//singleton
@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "Framework", "FrameworkDescription"),
			new Topic(2, "Language", "Core Java"),
			new Topic(3, "UI", "Javascript")));
	
	private List<Topic> topicsV2 = new ArrayList<>(Arrays.asList(
			new Topic(1, "Framework_V2", "FrameworkDescription"),
			new Topic(2, "Language_V2", "Core Java"),
			new Topic(3, "UI_V2", "Javascript")));

	public String getHomePage(){
		return "Welcome to Spring !";
	}
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public List<Topic> getAllTopicsV2() {
		return topicsV2;
	}
	
	public Topic getTopic(Integer id) {
		Topic topic = null;
		try{
			topic  = topics.stream().filter(t -> t.getId()==id).findFirst().get();
		}catch(Exception e){
			 if(topic == null)
					throw new TopicNotFoundException("Selected topic with id: "+id+" is not available");
		}
		return topic;
	}
	
	public Topic getTopicV2(Integer id) {
		Topic topic = null;
		try{
			topic  = topicsV2.stream().filter(t -> t.getId()==id).findFirst().get();
		}catch(Exception e){
			 if(topic == null)
				 throw new TopicNotFoundException("Selected topic with id: "+id+" is not available");
		}
		return topic;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Integer id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if (t.getId()==id) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public boolean deleteTopic(String id) {
		Integer topicId = Integer.parseInt(id);
		Boolean isTopicRemoved = null;
		isTopicRemoved = topics.removeIf(t -> t.getId()==topicId);
		if(!isTopicRemoved)
			throw new TopicNotFoundException("Topic id = "+id);
		
		return isTopicRemoved;
	}

}
