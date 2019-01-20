package com.example.demo.mybatisplus.service;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mybatisplus.dao.RoleMapper;
import com.example.demo.mybatisplus.pojo.Role;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	
	public List<Role> getRoleList(Integer id) {
		return this.baseMapper.findAllRolesById(id);
	}

	@Override
	public Page<Role> getPage(Page<Role> page) {
		// TODO Auto-generated method stub
		List<Role> roleList = this.baseMapper.page(page,"销售");
		return page.setRecords(roleList);
	}

	@Override
	public boolean save(Role entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBatch(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(Role entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role entity, Wrapper<Role> updateWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<Role> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(Role entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Role> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Role> listByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getOne(Wrapper<Role> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> list(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Role> page(IPage<Role> page, Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<Role> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> pageMaps(IPage<Role> page, Wrapper<Role> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleMapper getBaseMapper() {
		return this.baseMapper;
	}

	@Override
	public Page<Role> getRolePage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Role role) {
	   // TODO Auto-generated method stub
		return this.baseMapper.insert(role);
	}
}
