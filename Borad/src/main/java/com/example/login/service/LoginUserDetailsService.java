package com.example.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.login.dao.LoginUserDao;
import com.example.login.entity.LoginUser;

/**
 *
 * 認証を扱うService
 * @author jun
 *
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginUserDao userDao;

	/**
	 * ユーザー読み込み
	 * フォームから取得したユーザー名でDB検索
	 * 合致したとき、パスワード、権限情報とともにUserDetailsオブジェクトを生成
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		LoginUser user = userDao.findUser(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User" + userName + "was not found in the database");
		}
		//権限のリスト
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails userDetails = (UserDetails)new User(user.getUserName(), encoder.encode(user.getPassword()),grantList);

		return userDetails;
	}


}
