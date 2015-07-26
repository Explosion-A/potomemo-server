package com.tt.potomemo.modules.poto.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.tt.potomemo.common.persistence.DataEntity;

/**
 * potoEntity
 * @author dong
 * @version 2015-07-26
 */
public class Poto extends DataEntity<Poto> {
	
	private static final long serialVersionUID = 1L;
	private Integer userId;		// user_id
	private String imgNormal;		// img_normal
	private String imgSmall;		// img_small
	private String imgLabel;		// 图片标签
	private String content;		// 图片文字
	private String position;		// 位置
	private String syn;		// 同步
	
	public Poto() {
		super();
	}

	public Poto(String id){
		super(id);
	}

	@NotNull(message="user_id不能为空")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=100, message="img_normal长度必须介于 0 和 100 之间")
	public String getImgNormal() {
		return imgNormal;
	}

	public void setImgNormal(String imgNormal) {
		this.imgNormal = imgNormal;
	}
	
	@Length(min=0, max=100, message="img_small长度必须介于 0 和 100 之间")
	public String getImgSmall() {
		return imgSmall;
	}

	public void setImgSmall(String imgSmall) {
		this.imgSmall = imgSmall;
	}
	
	@Length(min=0, max=100, message="图片标签长度必须介于 0 和 100 之间")
	public String getImgLabel() {
		return imgLabel;
	}

	public void setImgLabel(String imgLabel) {
		this.imgLabel = imgLabel;
	}
	
	@Length(min=0, max=500, message="图片文字长度必须介于 0 和 500 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=50, message="位置长度必须介于 0 和 50 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Length(min=0, max=50, message="同步长度必须介于 0 和 50 之间")
	public String getSyn() {
		return syn;
	}

	public void setSyn(String syn) {
		this.syn = syn;
	}
	
}