package com.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

	@Autowired
	private CustomExpiredSessionStrategy customExpiredSessionStrategy;

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//如果token表不存在，使用下面语句可以初始化该表；若存在，请注释掉这条语句，否则会报错。
		//tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setPermissionEvaluator(new CustomPermissionEvaluator());
		return handler;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(rawPassword.toString());
			}
		});
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//设置拦截忽略文件夹，可以对静态资源放行
		web.ignoring().antMatchers("/css/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//如果有允许匿名的url，填在下面
				//.antMatchers().permitAll()
				.antMatchers("/login/invalid").permitAll()
				.anyRequest().authenticated()
				//设置登陆页
				.and().formLogin().loginPage("/login")
				//设置登陆成功页
				//.defaultSuccessUrl("/")
				.successHandler(customAuthenticationSuccessHandler)
				//.failureUrl("/login/error")
				.failureHandler(customAuthenticationFailureHandler)
				.permitAll()
				//自定义登陆用户名和密码参数，默认为username和password
				//.usernameParameter("username")
				//.passwordParameter("password")
				.and().logout().permitAll()
				.and().rememberMe()
				.tokenRepository(persistentTokenRepository())
				//有效时间：单位s
				.tokenValiditySeconds(60)
				.userDetailsService(customUserDetailsService)
				.and().sessionManagement().invalidSessionUrl("/login/invalid")
				//指定最大登录数
				.maximumSessions(1)
				//当达到最大值时，是否保留已经登录的用户，为true，新用户无法登录；为 false，旧用户被踢出
				.maxSessionsPreventsLogin(false)
				//当达到最大值时，旧用户被踢出后的操作
				.expiredSessionStrategy(customExpiredSessionStrategy);

		//关闭CSRF跨域
		http.csrf().disable();
	}
}
