package com.example.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.login.service.LoginUserDetailsService;

/**
 * SpringSecurityを利用するための設定クラス
 * ログイン処理でのパラメーター、画面遷移や認証処理でのデータアクセス先を設定する
 * @author jun
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginUserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		//静的リソースをセキュリティ対象外に設定
		web.ignoring().antMatchers("/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//認可の設定
			.authorizeRequests()
				//「login.html」はログイン不要でアクセス可能に設定
				.antMatchers("/login", "/sign_up").permitAll()
				//上記以外は直リンク禁止
				.anyRequest().authenticated()
				.and()

			//ログイン設定
			.formLogin()
				//ログインページ
				.loginPage("/login")
				//ログイン処理のパス
				.loginProcessingUrl("/sign_in")
				//ログイン成功時のキー:名前
				.usernameParameter("username")
				//ログイン時のパスワード
				.passwordParameter("password")
				//ログイン成功時の遷移先
				.successForwardUrl("/menu")
				//ログインエラー時の遷移先
				.failureUrl("/login?error")
				.permitAll()
				.and()

			//ログアウト設定
			.logout()
				.logoutUrl("/logout")
				//ログアウト時の遷移先POSTでアクセス
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/**
	 * 認証時に利用するデータソースを定義するメソッド
	 * DBから取得したユーザー情報をuserDetailsServiceへセットすることで認証時の比較情報としている
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
