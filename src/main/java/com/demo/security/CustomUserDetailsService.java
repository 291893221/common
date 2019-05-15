package com.demo.security;

import com.demo.model.SysRole;
import com.demo.model.SysUser;
import com.demo.model.SysUserRole;
import com.demo.service.SysRoleService;
import com.demo.service.SysUserRoleService;
import com.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		// 从数据库中取出用户信息
		SysUser user = new SysUser();
		user.setUsername(username);
		List<SysUser> list = sysUserService.selectBySelective(user);

		// 判断用户是否存在
		if (list == null || list.size()==0) {
			throw new UsernameNotFoundException("用户名不存在list");
		}

		SysUser sysUser = list.get(0);

		// 判断用户是否存在
		if (sysUser == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}

		// 添加权限
		List<SysUserRole> sysUserRoleList = sysUserRoleService.listByUserId(sysUser.getId());
		for (SysUserRole sysUserRole : sysUserRoleList) {
			SysRole sysRole = sysRoleService.selectByPrimaryKey(sysUserRole.getRoleId());
			authorities.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
		}

		// 返回UserDetails实现类
		return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
	}
}