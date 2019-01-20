package com.example.demo.mybatisplus.dao;



import java.util.List;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mybatisplus.pojo.Role;


public interface RoleMapper extends BaseMapper<Role> {
	
	
   List<Role> findAllRolesById(Integer id);
   
   List<Role> page(Page<Role> page, String name);
   
   
}
