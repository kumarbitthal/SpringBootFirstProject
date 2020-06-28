package com.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.number.IsCloseTo;
import org.springframework.stereotype.Service;

//singleton
@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "Framework", "FrameworkDescription"),
			new Topic(2, "core Java", "COreJavaDescription"),
			new Topic(3, "Javascript", "JavascriptDescription")));

	public String getHomePage(){
		return "Welcome to Spring !";
	}
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(Integer id) {
		Topic topic = null;
		try{
			topic  = topics.stream().filter(t -> t.getId()==id).findFirst().get();
		}catch(Exception e){
			 if(topic == null)
					throw new UserNotFoundException("Topic id = "+id);
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
			throw new UserNotFoundException("Topic id = "+id);
		
		return isTopicRemoved;
	}

}
