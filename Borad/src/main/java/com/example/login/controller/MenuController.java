package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.login.entity.NewUserForm;
import com.example.login.service.UserService;
import com.example.message.entity.Message;
import com.example.message.form.MessageForm;
import com.example.message.service.MessageService;

@Controller
public class MenuController {

	@Autowired
	private MessageService service;

	@Autowired
	private UserService userService;

	/**
	 * ログイン成功時に呼び出されるメソッド
	 * SecurityContextHolderから認証済みユーザーの情報を取得しモデルへ追加する
	 * @param model リクエストスコープ上にオブジェクトを乗せるためのmap
	 * @return menuページのViewName
	 */
	@RequestMapping("/menu")
	public String init(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//ログインユーザーの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);

		model.addAttribute("messageForm", new MessageForm());
		List<Message> messages = service.getRecentMessages(100);
		model.addAttribute("messages", messages);

		return "menu";
	}

	//新規登録画面へ遷移
	@GetMapping("/sign_up")
	public String singUp(@ModelAttribute("newUser") NewUserForm newUser) {
		return "sign_up";
	}

	@PostMapping("/sign_up")
	public String userRegister(@ModelAttribute NewUserForm newUser, BindingResult bindingResult) {


		userService.create(newUser);
		return "login";
	}

}