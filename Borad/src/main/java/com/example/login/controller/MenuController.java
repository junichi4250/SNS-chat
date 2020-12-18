package com.example.login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

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
		return "menu";
	}

}
