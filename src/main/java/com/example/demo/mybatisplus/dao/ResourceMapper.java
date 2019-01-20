package com.example.demo.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mybatisplus.pojo.Resource;

//如果启动ActiveRecord必须定义接口Mapper否则会报实体对象Not found in TableInfoCache的错误
public interface ResourceMapper extends BaseMapper<Resource> {
}
