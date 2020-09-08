package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about Topics..")
@Entity
public class Topic {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, max=44)
	@ApiModelProperty(notes="Topic name should be of min 2 and max 44 characters")
	private String name;
	private String description;

	public Topic() {
	}
	
	public Topic(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
