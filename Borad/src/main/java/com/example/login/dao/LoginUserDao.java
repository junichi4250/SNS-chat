package com.example.login.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.login.entity.LoginUser;
/**
 * DBへのアクセスメソッドを呼び出すDao
 * @author jun
 *
 */
@Repository
public class LoginUserDao {

	@Autowired
	EntityManager em;

	/**
	 * フォームの入力値から該当するユーザーを検索 合致するものがない場合Nullが返される
	 * @param userName
	 * @return 一致するユーザが存在するとき:UserEntity,存在しないとき:Null
	 */
	public LoginUser findUser(String userName) {
		String query = "";
		query += "SELECT * ";
		query += "FROM public.user ";
		query += "WHERE username = :userName";

		//EntityManagerで取得された結果はオブジェクトになるので、LoginUser型へキャストが必要
		return (LoginUser)em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName)
				.getSingleResult();
	}

}
