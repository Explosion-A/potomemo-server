package com.tt.potomemo.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.service.CrudService;
import com.tt.potomemo.modules.user.dao.UserDao;
import com.tt.potomemo.modules.user.entity.User;

/**
 * 用户模块Service
 * @author dong
 * @version 2015-07-20
 */
@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User> {

	public User get(String id) {
		return super.get(id);
	}
	
	public List<User> findList(User user) {
		return super.findList(user);
	}
	
	public Page<User> findPage(Page<User> page, User user) {
		return super.findPage(page, user);
	}
	
	@Transactional(readOnly = false)
	public void save(User user) {
		super.save(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(User user) {
		super.delete(user);
	}
	
}