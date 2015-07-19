package com.tt.potomemo.modules.poto.entity;

import org.hibernate.validator.constraints.Length;

import com.tt.potomemo.common.persistence.DataEntity;

/**
 * cashEntity
 * @author dong
 * @version 2015-06-24
 */
public class Cash extends DataEntity<Cash> {
	
	private static final long serialVersionUID = 1L;
	private Integer type;		// type
	private String icon;		// icon
	private Integer cash;		// cash
	private Integer needjpoints;		// needjpoints
	private String detail;		// detail
	
	public Cash() {
		super();
	}

	public Cash(String id){
		super(id);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	@Length(min=0, max=1000, message="icon长度必须介于 0 和 1000 之间")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}
	
	public Integer getNeedjpoints() {
		return needjpoints;
	}

	public void setNeedjpoints(Integer needjpoints) {
		this.needjpoints = needjpoints;
	}
	
	@Length(min=0, max=500, message="detail长度必须介于 0 和 500 之间")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}