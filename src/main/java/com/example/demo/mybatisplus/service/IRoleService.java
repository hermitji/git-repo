package com.example.demo.mybatisplus.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mybatisplus.pojo.Role;

public interface IRoleService extends  IService<Role> {

	public Page<Role> getRolePage();
	
	Page<Role> getPage(Page<Role> page);
	
	int insert(Role role);
	
}
