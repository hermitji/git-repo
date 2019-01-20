package com.example.demo.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;


/**
 * ActiveReord模式
 */
@TableName(value="resource")
public class Resource extends Model implements Serializable {

    @TableId(value="id")
    private Integer id;

    @TableField(value="url")
    private String url;

    @TableField(value="res_name")
    private String resName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
