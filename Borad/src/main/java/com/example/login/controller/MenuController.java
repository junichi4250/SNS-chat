package com.example.login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.message.form.MessageForm;

@Controller
public class MenuController {

	/**
	 * ログイン成功時に呼び出されるメソッド
	 * SecurityContextHolderから認証済みユーザーの情報を取得しモデルへ追加する
	 * @param model リクエストスコープ上にオブジェクトを乗せるためのmap
	 * @return menuページのViewName
	 */
	@GetMapping("/menu")
	public String init(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//ログインユーザーの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "menu";
	}


	@PostMapping("/menu")
	public String messagePost(Model model, @Valid MessageForm messageform, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Message> messages = service.getRecentMessages(100);
			model.addAttribute("messages", messages);
			return "menu";
		}

		service.save(new Message(messageForm.getName(), messageForm.getText()));
		return "redirect:/menu";
	}

}
