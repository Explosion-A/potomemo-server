package com.tt.potomemo.modules.user.dao;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.annotations.Param;

import com.tt.potomemo.common.persistence.CrudDao;
import com.tt.potomemo.common.persistence.annotation.MyBatisDao;
import com.tt.potomemo.modules.user.entity.User;

/**
 * 用户模块DAO接口
 * @version 2015-07-20
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {
	
	User getUserByPhoneOrEmail(@Param("phoneOrEmail")String phoneOrEmail);
	
}