package com.tt.potomemo.modules.user.dao;

import com.tt.potomemo.common.persistence.CrudDao;
import com.tt.potomemo.common.persistence.annotation.MyBatisDao;
import com.tt.potomemo.modules.user.entity.User;

/**
 * 用户模块DAO接口
 * @version 2015-07-20
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {
	
}