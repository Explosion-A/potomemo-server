package com.tt.potomemo.modules.user.service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.potomemo.common.persistence.Page;
import com.tt.potomemo.common.service.CrudService;
import com.tt.potomemo.common.utils.MD5Encrypt;
import com.tt.potomemo.common.utils.MD5Util;
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
		boolean mobileNO = PhoneAndEmailUtil.isMobileNO(user.getPhone());
		boolean email = PhoneAndEmailUtil.isEmail(user.getPhone());
		if(!mobileNO && !email){
			state = 0;
		}else{
			User userByPhoneOrEmail = userDao.getUserByPhoneOrEmail(user.getPhone());
			if(userByPhoneOrEmail == null){
				String password = user.getPassword();
				if(password!=null && password.length()>=6 && password.length()<=18){
					String md5String = MD5Util.getMD5String(password);
					user.setPassword(md5String);
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
					state = 3 ; //密码长度不符合规范
				}
			}else{
				state = 2;//已经存在该用户
			}
		}
		return state;
	}
	
	public User login(User user){
		User userByPhoneOrEmail = userDao.getUserByPhoneOrEmail(user.getPhone());
		if(userByPhoneOrEmail==null){
			userByPhoneOrEmail = new User();
			userByPhoneOrEmail.setState("accountErr");
		}else{
			if(!MD5Util.getMD5String(user.getPassword()).equals(userByPhoneOrEmail.getPassword())){ //密码不对
				userByPhoneOrEmail.setState("pswErr");
			}else{
				userByPhoneOrEmail.setState("ok");
			}
		}
		return userByPhoneOrEmail;
	}
	
	@Transactional(readOnly = false)
	public void delete(User user) {
		super.delete(user);
	}
	
}