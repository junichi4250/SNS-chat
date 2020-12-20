package com.example.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	//投稿内容
	@Column(name = "text", nullable = false)
	private String text;

	//投稿日時
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(updatable = false)
//	private Date createdAt;

	//Jpa用必須定義
	protected Message() {

	}

	public Message(String name, String text) {
		this.name = name;
		this.text = text;
	}

//	//投稿前処理
//	@PrePersist
//	public void prePersist() {
//		this.createdAt = new Date();
//	}

	@Override
	public String toString() {
		return "Message:" + id + " name:" + name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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

//	public Date getCreatedAt() {
//		return createdAt;
//	}


}
