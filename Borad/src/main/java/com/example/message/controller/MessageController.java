package com.example.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.message.entity.Message;
import com.example.message.form.MessageForm;
import com.example.message.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService service;

	@RequestMapping(value = "/message", params = "add")
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

	@RequestMapping(value = "/delete", params = "delete")
	public String deleteMessage(Model model, @RequestParam Long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//ログインユーザーの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);

		//投稿削除
		service.deleteById(id);

		List<Message> messages = service.getRecentMessages(100);
		model.addAttribute("messages", messages);
		model.addAttribute("messageForm", new MessageForm());
		return "menu";
	}
}
