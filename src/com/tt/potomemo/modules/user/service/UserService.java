package com.tt.potomemo.modules.user.service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.service.CrudService;
import com.tt.potomemo.common.utils.PhoneAndEmailUtil;
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

	@Autowired
	private UserDao userDao;
	
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
	public int register(User user){
		int state=0; //失败
		Use userByPhoneOrEmail = userDao.getUserByPhoneOrEmail(user.getPhone());
		if(userByPhoneOrEmail == null){
			boolean mobileNO = PhoneAndEmailUtil.isMobileNO(user.getPhone());
			boolean email = PhoneAndEmailUtil.isEmail(user.getPhone());
			if(mobileNO){
				super.save(user);
				state = 1; //成功
			}else if(email){
				user.setEmail(user.getPhone());
				user.setPhone(null);
				super.save(user);
				state = 1;
			}
		}else{
			state = 2;//已经存在该用户
		}
		return state;
	}
	
	@Transactional(readOnly = false)
	public void delete(User user) {
		super.delete(user);
	}
	
}