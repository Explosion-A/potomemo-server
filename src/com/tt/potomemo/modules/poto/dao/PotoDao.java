package com.tt.potomemo.modules.poto.dao;

import com.tt.potomemo.common.persistence.CrudDao;
import com.tt.potomemo.common.persistence.annotation.MyBatisDao;
import com.tt.potomemo.modules.poto.entity.Poto;

/**
 * potoDAO接口
 * @version 2015-07-26
 */
@MyBatisDao
public interface PotoDao extends CrudDao<Poto> {
	
}