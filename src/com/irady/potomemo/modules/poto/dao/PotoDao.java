package com.irady.potomemo.modules.poto.dao;

import com.irady.potomemo.common.persistence.CrudDao;
import com.irady.potomemo.common.persistence.annotation.MyBatisDao;
import com.irady.potomemo.modules.poto.entity.Poto;

/**
 * potoDAO接口
 * @version 2015-07-26
 */
@MyBatisDao
public interface PotoDao extends CrudDao<Poto> {
	
}