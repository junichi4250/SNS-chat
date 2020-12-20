package com.example.message.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.message.entity.Message;
import com.example.message.repository.MessageRepository;

@Service
@Transactional
public class MessageService {

	@Autowired
	MessageRepository repository;

	public List<Message> getRecentMessages(Integer n) {
		return repository.findByOrderByIdDesc(PageRequest.of(0, n));
	}

	public Message postMessage(Message message) {
		return repository.save(message);
	}

}