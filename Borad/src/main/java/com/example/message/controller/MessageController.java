package com.example.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.message.entity.Message;
import com.example.message.form.MessageForm;
import com.example.message.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService service;

	@RequestMapping("/message")
	public String messagesPost(Model model, @Valid MessageForm messageForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Message> messages = service.getRecentMessages(100);
			model.addAttribute("messages", messages);
			return "menu";
		}

		List<Message> messages = service.getRecentMessages(100);
		model.addAttribute("messages", messages);

		service.postMessage(new Message(messageForm.getName(), messageForm.getText()));
		return "menu";

	}
}
