package com.tt.potomemo.modules.poto.dao;

import com.tt.potomemo.common.persistence.CrudDao;
import com.tt.potomemo.common.persistence.annotation.MyBatisDao;
import com.tt.potomemo.modules.poto.entity.Cash;

/**
 * cashDAO接口
 * @version 2015-06-24
 */
@MyBatisDao
public interface CashDao extends CrudDao<Cash> {
	
}