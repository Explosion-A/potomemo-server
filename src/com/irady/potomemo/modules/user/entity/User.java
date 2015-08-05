package com.irady.potomemo.modules.user.entity;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.irady.potomemo.common.persistence.DataEntity;

/**
 * 用户模块Entity
 * @author dong
 * @version 2015-07-20
 */
public class User extends DataEntity<User> {
	
	private static final long serialVersionUID = 1L;
	private Integer userType;		// 用户类型
	private String loginName;		// 登录名
	
	@JsonIgnore
	private String password;		// 密码
	private String email;		// email
	private String phone;		// phone
	private String photo;		// 图片
	private String loginIp;		// 登录ip
	private Date createTime;		// 创建时间
	private Date lastLoginTime;		// 上次登录时间
	private Date beginCreateTime;		// 开始 创建时间
	private Date endCreateTime;		// 结束 创建时间
	private Date beginLastLoginTime;		// 开始 上次登录时间
	private Date endLastLoginTime;		// 结束 上次登录时间
	private String state;
	
	public User() {
		super();
	}

	public User(String id){
		super(id);
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	@Length(min=0, max=64, message="登录名长度必须介于 0 和 64 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=0, max=64, message="密码长度必须介于 0 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=64, message="email长度必须介于 0 和 64 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=32, message="phone长度必须介于 0 和 32 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=100, message="图片长度必须介于 0 和 100 之间")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=0, max=32, message="登录ip长度必须介于 0 和 32 之间")
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public Date getBeginCreateTime() {
		return beginCreateTime;
	}

	public void setBeginCreateTime(Date beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}
	
	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
		
	public Date getBeginLastLoginTime() {
		return beginLastLoginTime;
	}

	public void setBeginLastLoginTime(Date beginLastLoginTime) {
		this.beginLastLoginTime = beginLastLoginTime;
	}
	
	public Date getEndLastLoginTime() {
		return endLastLoginTime;
	}

	public void setEndLastLoginTime(Date endLastLoginTime) {
		this.endLastLoginTime = endLastLoginTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
		
}