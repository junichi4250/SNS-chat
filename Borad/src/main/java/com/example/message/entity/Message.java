package com.example.message.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdAt;

	protected Message() {

	}

	public Message(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
