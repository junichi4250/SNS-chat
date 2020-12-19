package com.example.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.message.repository.MessageRepository;

@Service
@Transactional
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public List<Message> getRecentMessages(Integer n) {
		return repository.findByOrderByIdDesc(new PageRequest(0, n));
	}

	public Message postMessage(Message message) {
		return messageRepository.save(message);
	}

	public List<Message> getMessage() {
		return messageRepository.findAll();
	}
}
