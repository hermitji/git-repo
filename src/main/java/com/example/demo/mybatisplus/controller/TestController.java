package com.example.demo.mybatisplus.controller;

import java.util.List;

import com.example.demo.mybatisplus.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mybatisplus.pojo.Role;
import com.example.demo.mybatisplus.service.RoleService;

@RestController
public class TestController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/test")
	public Object testMybatisPage() {
		Page<Role> pg = new Page<Role>(1, 2);
		roleService.getPage(pg);
		Role role = new Role();
		role.setRoleName("role_xxxx");
		role.setRoleNameZh("测试角色");
		//int id = roleService.insert(role);

		Resource resource = new Resource();
		resource.setResName("test");
		resource.setUrl("/test");
		resource.insert();

		return pg.getRecords().get(0);
	}
}
